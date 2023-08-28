package com.sseung.pilot.seungpilotproject.commons.exception;

import com.sseung.pilot.seungpilotproject.commons.enums.ResultCode;
import lombok.Getter;

public class SignInException extends Exception{

    @Getter
    private ResultCode resultCode;

    public SignInException(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

}
