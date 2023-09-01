package com.sseung.pilot.seungpilotproject.business.board.service;

import com.sseung.pilot.seungpilotproject.business.board.domain.Board;
import com.sseung.pilot.seungpilotproject.business.board.repo.BoardRepo;
import com.sseung.pilot.seungpilotproject.business.board.repo.BoardRepoSupport;
import com.sseung.pilot.seungpilotproject.commons.dto.request.board.BoardRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.request.commons.BasicGetListRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.board.BoardResponse;
import com.sseung.pilot.seungpilotproject.commons.dto.response.board.GetBoardListResponse;
import com.sseung.pilot.seungpilotproject.commons.dto.response.board.GetMyBoardListResponse;
import com.sseung.pilot.seungpilotproject.commons.utils.ModelMapperUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public Board getOne(long bdId) {
        return boardRepo.findById(bdId)
                .orElseThrow(() -> new EntityNotFoundException("not exists " + bdId));
    }

    public BoardResponse findBoard(long bdId) {
        Board board = this.getOne(bdId);
        return ModelMapperUtil.get().map(board, BoardResponse.class);
    }

    public void addView(long bdId) {
        Board board = this.getOne(bdId);
        board.addView();
    }

    public Page<GetBoardListResponse> getBoardList(BasicGetListRequest request, Pageable pageable) {
        List<GetBoardListResponse> list = boardRepoSupport.getBoardList(request, pageable);
        Long total = boardRepoSupport.getBoardCount(request);

        pageable = pageable == null ? PageRequest.of(0, 10) : pageable;

        return new PageImpl<>(list, pageable, total);
    }

    public Page<GetMyBoardListResponse> getMyBoardList(Long userId, BasicGetListRequest request, Pageable pageable) {
        List<GetMyBoardListResponse> list = boardRepoSupport.getMyBoardList(userId, request, pageable);
        Long total = boardRepoSupport.getMyBoardCount(request);

        pageable = pageable == null ? PageRequest.of(0, 10) : pageable;

        return new PageImpl<>(list, pageable, total);
    }
}
