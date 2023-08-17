package com.sseung.pilot.seungpilotproject.business.comment.domain;

import com.sseung.pilot.seungpilotproject.commons.BaseEntity;
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

    @Column(columnDefinition = "bigint COMMENT '부모 댓글 아이디'")
    private Long parentId;

    @Column(columnDefinition = "bigint COMMENT '게시판 아이디'")
    private Long bdId;

}
