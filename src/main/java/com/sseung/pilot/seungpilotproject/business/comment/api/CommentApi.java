package com.sseung.pilot.seungpilotproject.business.comment.api;

import com.sseung.pilot.seungpilotproject.business.comment.service.CommentService;
import com.sseung.pilot.seungpilotproject.commons.dto.request.comment.CommentRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.request.comment.UpdateCommentRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.comment.CommentResponse;
import com.sseung.pilot.seungpilotproject.commons.resolver.LoginUser;
import com.sseung.pilot.seungpilotproject.commons.security.CustomUserDetails;
import com.sseung.pilot.seungpilotproject.commons.utils.ApiUtils.ApiResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import static com.sseung.pilot.seungpilotproject.commons.utils.ApiUtils.success;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentApi {
    private final CommentService commentService;

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ApiResult<CommentResponse> add(@RequestBody CommentRequest request, @LoginUser CustomUserDetails customUserDetails) {
        return success(commentService.insertComment(customUserDetails.getUserId(), request));
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PatchMapping("/{ctId}")
    public ApiResult<?> update(@PathVariable("ctId") Long ctId, @LoginUser CustomUserDetails customUserDetails, @RequestBody UpdateCommentRequest request) {
        commentService.updateComment(ctId, customUserDetails.getUserId(), request);
        return success();
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @DeleteMapping("/{ctId}")
    public ApiResult<?> delete(@PathVariable("ctId") Long ctId, @LoginUser CustomUserDetails customUserDetails) {
        commentService.delete(customUserDetails.getUserId(), ctId);
        return success();
    }
}
