package com.sseung.pilot.seungpilotproject.commons.dto.response.board;

import com.sseung.pilot.seungpilotproject.commons.enums.BoardCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetBoardListResponse {
    private Long bdId;
    private String title;
    private Long view;
    private LocalDateTime createdDate;
    private BoardCategory boardCategory;
    private Long userId;
}
