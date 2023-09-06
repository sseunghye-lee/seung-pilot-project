package com.sseung.pilot.seungpilotproject.business.board.api;

import com.sseung.pilot.seungpilotproject.business.board.service.BoardService;
import com.sseung.pilot.seungpilotproject.commons.dto.request.board.BoardRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.request.board.UpdateBoardRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.request.commons.BasicGetListRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.board.BoardResponse;
import com.sseung.pilot.seungpilotproject.commons.dto.response.board.GetBoardListResponse;
import com.sseung.pilot.seungpilotproject.commons.dto.response.board.GetMyBoardListResponse;
import com.sseung.pilot.seungpilotproject.commons.utils.ApiUtils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.sseung.pilot.seungpilotproject.commons.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardApi {
    private final BoardService boardService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ApiResult<BoardResponse> add(@RequestBody BoardRequest boardRequest) {
        return success(boardService.insertBoard(boardRequest));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{bdId}")
    public ApiResult<BoardResponse> getBoard(@PathVariable("bdId") Long bdId) {
        return success(boardService.findBoard(bdId));
    }

    @PatchMapping("/{bdId}/view")
    public ApiResult<?> addView(@PathVariable("bdId") Long bdId) {
        boardService.addView(bdId);
        return success();
    }

    @PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_MASTER')")
    @GetMapping
    public ApiResult<Page<GetBoardListResponse>> getList(BasicGetListRequest request, Pageable pageable) {
        return success(boardService.getBoardList(request, pageable));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/{userId}/my")
    public ApiResult<Page<GetMyBoardListResponse>> getList(@PathVariable("userId") Long userId, BasicGetListRequest request, Pageable pageable) {
        return success(boardService.getMyBoardList(userId, request, pageable));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PatchMapping("/{bdId}")
    public ApiResult<?> update(@PathVariable("bdId") Long bdId, @RequestBody UpdateBoardRequest request) {
        boardService.updateBoard(bdId, request);
        return success();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{bdId}")
    public ApiResult<?> delete(@PathVariable("bdId") Long bdId) {
        boardService.delete(bdId);
        return success();
    }
}
