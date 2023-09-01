package com.sseung.pilot.seungpilotproject.commons.dto.response.user;

import com.sseung.pilot.seungpilotproject.commons.enums.Gender;
import com.sseung.pilot.seungpilotproject.commons.security.EncryptService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private Long userId;
    private String birth;
    private Gender gender;
    private String nickName;
    private String userEmail;
    private String userName;
    private String userPhoneNumber;

}
