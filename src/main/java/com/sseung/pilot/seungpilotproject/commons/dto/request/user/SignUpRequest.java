package com.sseung.pilot.seungpilotproject.commons.dto.request.user;

import com.sseung.pilot.seungpilotproject.commons.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Setter
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank
    private String userEmail;

    @NotBlank
    private String loginPw;

    @NotBlank
    private String userName;

    @NotBlank
    private String userPhoneNumber;

    @NotBlank
    private String nickName;

    private String birth;

    private Gender gender;

}
