package com.comento.practical.dto;

import com.comento.practical.exception.PracticalErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PracticalErrorResponse {
    private PracticalErrorCode errorCode;
    private String errorMessage;

}
