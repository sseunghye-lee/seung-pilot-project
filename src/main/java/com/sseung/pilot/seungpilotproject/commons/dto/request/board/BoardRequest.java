package com.sseung.pilot.seungpilotproject.commons.dto.request.board;

import com.sseung.pilot.seungpilotproject.commons.enums.BoardCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequest {
    private BoardCategory boardCategory;
    private String title;
    private Long view;
    private String content;
}
