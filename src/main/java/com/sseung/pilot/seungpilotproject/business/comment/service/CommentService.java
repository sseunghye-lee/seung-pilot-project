package com.sseung.pilot.seungpilotproject.business.comment.service;

import com.sseung.pilot.seungpilotproject.business.board.domain.Board;
import com.sseung.pilot.seungpilotproject.business.board.service.BoardService;
import com.sseung.pilot.seungpilotproject.business.comment.domain.Comments;
import com.sseung.pilot.seungpilotproject.business.comment.repo.CommentRepo;
import com.sseung.pilot.seungpilotproject.business.user.domain.Users;
import com.sseung.pilot.seungpilotproject.business.user.service.UserService;
import com.sseung.pilot.seungpilotproject.commons.dto.request.comment.CommentRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.request.comment.UpdateCommentRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.comment.CommentResponse;
import com.sseung.pilot.seungpilotproject.commons.exception.NotAuthorizedException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepo commentRepo;
    private final BoardService boardService;

    public Comments getOne(Long ctId) {
        return commentRepo.findById(ctId)
                .orElseThrow(() -> new EntityNotFoundException("not exists " + ctId));
    }

    public CommentResponse insertComment(Long userId, CommentRequest request) {
        Board board = boardService.getOne(request.getBdId());
        request.setBoard(board);
        Comments comment = Comments.insert(userId, request);
        commentRepo.save(comment);
        return comment.convertDto();
    }

    public void updateComment(Long ctId, Long userId, UpdateCommentRequest request) {
        Comments comment = this.getOne(ctId);

        if(comment.getUserId() != userId) {
            throw new NotAuthorizedException("수정 불가능한 계정입니다.");
        }

        comment.updateComment(request);
    }

    public void delete(Long userId, Long ctId) {
        Comments comment = this.getOne(ctId);

        if(comment.getUserId() != userId) {
            throw new NotAuthorizedException("삭제 불가능한 계정입니다.");
        }

        commentRepo.delete(comment);
    }
}
