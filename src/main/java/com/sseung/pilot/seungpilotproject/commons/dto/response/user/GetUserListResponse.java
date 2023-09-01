package com.sseung.pilot.seungpilotproject.commons.dto.response.user;

import com.sseung.pilot.seungpilotproject.commons.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetUserListResponse {
    private Long userId;
    private LocalDateTime createdDate;
    private Gender gender;
    private String userName;
    private String nickName;
}
