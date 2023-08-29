package com.sseung.pilot.seungpilotproject.business.user.service;

import com.sseung.pilot.seungpilotproject.business.user.domain.Users;
import com.sseung.pilot.seungpilotproject.business.user.repo.UserRepo;
import com.sseung.pilot.seungpilotproject.commons.dto.request.user.SignUpRequest;
import com.sseung.pilot.seungpilotproject.commons.dto.response.user.SignUpResponse;
import com.sseung.pilot.seungpilotproject.commons.enums.ResultCode;
import com.sseung.pilot.seungpilotproject.commons.exception.SignInException;
import com.sseung.pilot.seungpilotproject.commons.security.EncryptService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;

    public Optional<Users> getUserByEmail(String userEmail) {
        return userRepo.findByUserEmail(userEmail);
    }

    public Users makeUser(SignUpRequest request) {
        request.setLoginPw(passwordEncoder.encode(request.getLoginPw()));
        request.setUserPhoneNumber(EncryptService.encryptPhoneNumber(request.getUserPhoneNumber()));
        Users user = Users.init(request);

        userRepo.save(user);
        return user;
    }

    public SignUpResponse signUp(SignUpRequest request) throws SignInException {
        Optional<Users> getUser = this.getUserByEmail(request.getUserEmail());
        if (!getUser.isEmpty()) {
            throw new SignInException(ResultCode.CONFLICT, "이미 가입된 정보가 존재합니다.");
        }

        Users user = this.makeUser(request);

        return user.convertSignUpResponse();
    }
}
