package com.sseung.pilot.seungpilotproject.commons.dto.commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 420667802775156638L;

    private String fileName;
    private String filePath;
}
