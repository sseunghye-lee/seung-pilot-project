package com.sseung.pilot.seungpilotproject.business.board.repo;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sseung.pilot.seungpilotproject.business.board.domain.QBoard;
import com.sseung.pilot.seungpilotproject.commons.dto.request.commons.BasicGetListRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.board.GetBoardListResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class BoardRepoSupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final QBoard qBoard = QBoard.board;

    public BoardRepoSupport(JPAQueryFactory jpaQueryFactory) {
        super(JPAQueryFactory.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    public JPAQuery<?> getBoardListQuery(JPAQuery<?> query, BasicGetListRequest request) {
        String search = request.getSearch();

        if(StringUtils.hasText(search)) {
            query = query.where(qBoard.title.contains(search));
        }
        if (request.getStartDate() != null && request.getEndDate() != null) {
            query = query.where(
                    qBoard.createdDate.between(request.getStartDate(), request.getEndDate())
            );
        }
        return query;
    }

    public Long getBoardCount(BasicGetListRequest request) {
        JPAQuery<Long> query = jpaQueryFactory.select(qBoard.count())
                .from(qBoard);
        query = (JPAQuery<Long>) getBoardListQuery(query, request);

        return query.fetchOne();
    }

    public List<GetBoardListResponse> getBoardList(BasicGetListRequest request, Pageable pageable) {
        JPAQuery<GetBoardListResponse> query = jpaQueryFactory
                .select(Projections.bean(GetBoardListResponse.class, qBoard.bdId, qBoard.title, qBoard.view,
                        qBoard.createdDate, qBoard.boardCategory, qBoard.userId))
                .from(qBoard)
                .orderBy(qBoard.createdDate.desc());

        if(pageable != null) {
            query = query.offset(pageable.getOffset())
                    .limit(pageable.getPageSize());
        }

        query = (JPAQuery<GetBoardListResponse>) getBoardListQuery(query, request);

        List<GetBoardListResponse> results = query.fetch();

        return results;
    }
}
