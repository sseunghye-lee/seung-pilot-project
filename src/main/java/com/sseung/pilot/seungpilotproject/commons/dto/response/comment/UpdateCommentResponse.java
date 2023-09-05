package com.sseung.pilot.seungpilotproject.commons.dto.response.comment;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCommentResponse {
    private Long ctId;
    private String content;
    private LocalDateTime modifiedDate;
}
