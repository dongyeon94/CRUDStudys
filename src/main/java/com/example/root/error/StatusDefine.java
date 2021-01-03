package com.example.root.error;

import lombok.Getter;

@Getter
public enum StatusDefine {
    //SUCCESS
    SUCCESS(200),

    //FAIL
    ERROR_BAD_REQUEST(400),
    ERROR_NOT_FOUNT(404),
    ERROR_UNAUTHORIZED(401),


    ERROR_CONNECTION_TIMEOUT(599),;

    private int code;

    StatusDefine(int code){
        this.code = code;
    }
}
