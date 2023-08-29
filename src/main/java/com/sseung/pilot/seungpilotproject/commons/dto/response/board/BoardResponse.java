package com.sseung.pilot.seungpilotproject.commons.dto.response.board;

import com.sseung.pilot.seungpilotproject.commons.enums.BoardCategory;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse {
    private Long bdId;
    private BoardCategory boardCategory;
    private String title;
    private Long view;
    private String content;
    private Long userId;
}
