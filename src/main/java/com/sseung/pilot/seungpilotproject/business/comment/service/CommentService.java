package com.sseung.pilot.seungpilotproject.business.comment.service;

import com.sseung.pilot.seungpilotproject.business.board.domain.Board;
import com.sseung.pilot.seungpilotproject.business.board.service.BoardService;
import com.sseung.pilot.seungpilotproject.business.comment.domain.Comments;
import com.sseung.pilot.seungpilotproject.business.comment.repo.CommentRepo;
import com.sseung.pilot.seungpilotproject.commons.dto.request.comment.CommentRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.comment.CommentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;
    private final BoardService boardService;

    public CommentResponse insertComment(CommentRequest request) {
        Board board = boardService.getOne(request.getBdId());
        request.setBoard(board);
        Comments comment = Comments.insert(request);
        commentRepo.save(comment);
        return comment.convertDto();
    }
}
