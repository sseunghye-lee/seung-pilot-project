package com.sseung.pilot.seungpilotproject.business.board.repo;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.sseung.pilot.seungpilotproject.business.board.domain.QBoard;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class BoardRepoSupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final QBoard qBoard = QBoard.board;

    public BoardRepoSupport(JPAQueryFactory jpaQueryFactory) {
        super(JPAQueryFactory.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }
}
