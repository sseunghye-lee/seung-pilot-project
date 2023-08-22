package com.sseung.pilot.seungpilotproject.business.board.service;

import com.sseung.pilot.seungpilotproject.business.board.domain.Board;
import com.sseung.pilot.seungpilotproject.business.board.repo.BoardRepo;
import com.sseung.pilot.seungpilotproject.business.board.repo.BoardRepoSupport;
import com.sseung.pilot.seungpilotproject.commons.dto.request.board.BoardRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.BoardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepo boardRepo;
    private final BoardRepoSupport boardRepoSupport;

    public BoardResponse insertBoard(BoardRequest boardRequest) {
        Board board = Board.insert(boardRequest);
        boardRepo.save(board);
        return board.convertDto();
    }
}
