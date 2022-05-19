package com.comento.practical.exception;

import lombok.Getter;

@Getter
public class PracticalException extends RuntimeException{
    private PracticalErrorCode practicalErrorCode;
    private String detailMessage;

    //기본 에러 메시지
    public PracticalException(PracticalErrorCode practicalErrorCode){
        super(practicalErrorCode.getMessage());//RuntimeException에 담아줄 데이터를 넣어줌
        this.practicalErrorCode = practicalErrorCode;
        this.detailMessage = practicalErrorCode.getMessage();
    }

    //디테일 메시지
    public PracticalException(PracticalErrorCode practicalErrorCode, String detailMessage){
        super(detailMessage);//RuntimeException에 담아줄 데이터를 넣어줌
        this.practicalErrorCode = practicalErrorCode;
        this.detailMessage = detailMessage;
    }
}
