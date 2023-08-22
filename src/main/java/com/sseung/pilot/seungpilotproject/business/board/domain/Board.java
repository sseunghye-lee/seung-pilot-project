package com.sseung.pilot.seungpilotproject.business.board.domain;

import com.sseung.pilot.seungpilotproject.commons.BaseEntity;
import com.sseung.pilot.seungpilotproject.commons.dto.request.board.BoardRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.BoardResponse;
import com.sseung.pilot.seungpilotproject.commons.enums.BoardCategory;
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
public class Board extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -3139480046428247756L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bd_id", columnDefinition = "bigint COMMENT '게시판 아이디'")
    private Long bdId;

    @Column(columnDefinition = "varchar(50) COMMENT '카테고리'")
    @Enumerated(EnumType.STRING)
    private BoardCategory boardCategory;

    @Column(columnDefinition = "varchar(255) COMMENT '제목'")
    private String title;

    @Column(columnDefinition = "bigint COMMENT '조회수'")
    private Long view;

    @Column(columnDefinition = "mediumtext COMMENT '내용'")
    private String content;

    @Column(columnDefinition = "bigint COMMENT '사용자 아이디'")
    private Long userId;

    public static Board insert(BoardRequest boardRequest) {
        return Board.builder()
                .boardCategory(boardRequest.getBoardCategory())
                .title(boardRequest.getTitle())
                .view(0L)
                .content(boardRequest.getContent())
                .userId(boardRequest.getUserId())
                .build();
    }

    public BoardResponse convertDto() {
        return ModelMapperUtil.get().map(this, BoardResponse.class);
    }
}
