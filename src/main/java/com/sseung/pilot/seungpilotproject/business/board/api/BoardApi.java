package com.sseung.pilot.seungpilotproject.business.board.api;

import com.sseung.pilot.seungpilotproject.business.board.service.BoardService;
import com.sseung.pilot.seungpilotproject.commons.dto.request.board.BoardRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.board.BoardResponse;
import com.sseung.pilot.seungpilotproject.commons.utils.ApiUtils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.sseung.pilot.seungpilotproject.commons.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardApi {
    private final BoardService boardService;

    @PostMapping
    public ApiResult<BoardResponse> add(@RequestBody BoardRequest boardRequest) {
        return success(boardService.insertBoard(boardRequest));
    }

    @GetMapping("/{bdId}")
    public ApiResult<BoardResponse> getBoard(@PathVariable("bdId") long bdId) {
        return success(boardService.findBoard(bdId));
    }

    @PatchMapping("/{bdId}/view")
    public ApiResult<?> addView(@PathVariable("bdId") long bdId) {
        boardService.addView(bdId);
        return success();
    }
}
