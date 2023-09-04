package com.sseung.pilot.seungpilotproject.business.comment.domain;

import com.sseung.pilot.seungpilotproject.business.board.domain.Board;
import com.sseung.pilot.seungpilotproject.commons.BaseEntity;
import com.sseung.pilot.seungpilotproject.commons.dto.request.comment.CommentRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.comment.CommentResponse;
import com.sseung.pilot.seungpilotproject.commons.utils.ModelMapperUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comments extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -8962669242431554077L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "bigint COMMENT '댓글 아이디'")
    private Long ctId;

    @Column(columnDefinition = "mediumtext COMMENT '댓글 내용'")
    private String content;

    @Column(columnDefinition = "bigint COMMENT '게시글 ID'", insertable = false, updatable = false)
    private Long bdId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bdId")
    private Board board;

    public static Comments insert(CommentRequest request) {
        return Comments.builder()
                .bdId(request.getBdId())
                .content(request.getContent())
                .board(request.getBoard())
                .build();
    }

    public CommentResponse convertDto() {
        return ModelMapperUtil.get().map(this, CommentResponse.class);
    }

}
