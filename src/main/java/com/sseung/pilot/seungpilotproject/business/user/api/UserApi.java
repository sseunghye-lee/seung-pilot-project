package com.sseung.pilot.seungpilotproject.business.user.api;

import com.sseung.pilot.seungpilotproject.business.user.service.UserService;
import com.sseung.pilot.seungpilotproject.commons.dto.request.user.SignInRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.request.user.SignUpRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.user.SignInResponse;
import com.sseung.pilot.seungpilotproject.commons.dto.response.user.SignUpResponse;
import com.sseung.pilot.seungpilotproject.commons.exception.SignInException;
import com.sseung.pilot.seungpilotproject.commons.utils.ApiUtils.ApiResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sseung.pilot.seungpilotproject.commons.utils.ApiUtils.success;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/sign-up")
    public ApiResult<SignUpResponse> signUp(
            @Valid @RequestBody SignUpRequest request
    ) throws SignInException {
        return success(userService.signUp(request));
    }

    @PostMapping("/sign-in")
    public ApiResult<SignInResponse> signIn(@Valid @RequestBody SignInRequest request) throws SignInException {
        return success(userService.signIn(request));
    }
}
