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
public class CommentResponse {
    private Long ctId;
    private Long createdBy;
    private LocalDateTime modifiedDate;
    private String content;
    private Long bdId;
}
