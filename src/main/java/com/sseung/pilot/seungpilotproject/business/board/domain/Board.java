package com.sseung.pilot.seungpilotproject.business.board.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sseung.pilot.seungpilotproject.business.comment.domain.Comments;
import com.sseung.pilot.seungpilotproject.business.user.domain.UserRoles;
import com.sseung.pilot.seungpilotproject.commons.BaseEntity;
import com.sseung.pilot.seungpilotproject.commons.converter.FileConverter;
import com.sseung.pilot.seungpilotproject.commons.dto.commons.FileDto;
import com.sseung.pilot.seungpilotproject.commons.dto.request.board.BoardRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.request.board.UpdateBoardRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.board.BoardResponse;
import com.sseung.pilot.seungpilotproject.commons.enums.BoardCategory;
import com.sseung.pilot.seungpilotproject.commons.utils.ModelMapperUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @Convert(converter = FileConverter.class)
    @Column(columnDefinition = "varchar(1000) COMMENT '게시판 이미지'")
    private FileDto boardImg;

    @Column(columnDefinition = "bigint COMMENT '사용자 아이디'")
    private Long userId;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comments> comments;

    public static Board insert(Long userId, BoardRequest boardRequest) {
        return Board.builder()
                .boardCategory(boardRequest.getBoardCategory())
                .title(boardRequest.getTitle())
                .view(0L)
                .content(boardRequest.getContent())
                .userId(userId)
                .build();
    }

    public BoardResponse convertDto() {
        return ModelMapperUtil.get().map(this, BoardResponse.class);
    }

    public void addView() {
        this.view = this.view + 1;
    }

    public void updateBoard(UpdateBoardRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();

    }
}
