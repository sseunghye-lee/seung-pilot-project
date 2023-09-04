package com.sseung.pilot.seungpilotproject.business.comment.api;

import com.sseung.pilot.seungpilotproject.business.comment.service.CommentService;
import com.sseung.pilot.seungpilotproject.commons.dto.request.comment.CommentRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.comment.CommentResponse;
import com.sseung.pilot.seungpilotproject.commons.utils.ApiUtils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static com.sseung.pilot.seungpilotproject.commons.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentApi {
    private final CommentService commentService;

    @PostMapping
    public ApiResult<CommentResponse> add(@RequestBody CommentRequest request) {
        return success(commentService.insertComment(request));
    }
}
