package com.sseung.pilot.seungpilotproject.commons.dto.request.comment;

import com.sseung.pilot.seungpilotproject.business.board.domain.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {
    private Long bdId;
    private Board board;
    private String content;
}
