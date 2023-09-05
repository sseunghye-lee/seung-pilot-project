package com.sseung.pilot.seungpilotproject.business.comment.api;

import com.sseung.pilot.seungpilotproject.business.comment.service.CommentService;
import com.sseung.pilot.seungpilotproject.commons.dto.request.comment.CommentRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.request.comment.UpdateCommentRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.comment.CommentResponse;
import com.sseung.pilot.seungpilotproject.commons.resolver.LoginUser;
import com.sseung.pilot.seungpilotproject.commons.security.CustomUserDetails;
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
    public ApiResult<CommentResponse> add(@RequestBody CommentRequest request, @LoginUser CustomUserDetails customUserDetails) {
        return success(commentService.insertComment(customUserDetails.getUserId(), request));
    }

    @PatchMapping("/{ctId}")
    public ApiResult<?> update(@PathVariable("ctId") Long ctId, @LoginUser CustomUserDetails customUserDetails, @RequestBody UpdateCommentRequest request) {
        commentService.updateComment(ctId, customUserDetails.getUserId(), request);
        return success();
    }

    @DeleteMapping("/{ctId}")
    public ApiResult<?> delete(@PathVariable("ctId") Long ctId, @LoginUser CustomUserDetails customUserDetails) {
        commentService.delete(customUserDetails.getUserId(), ctId);
        return success();
    }
}
