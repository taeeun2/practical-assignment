package com.comento.practical.dto;

import com.comento.practical.type.Position_type;
import lombok.*;

import javax.validation.constraints.NotNull;

public class UpdateManager {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private int id;
        @NotNull
        private Position_type position_type;
        @NotNull
        private String phone_number;
    }
}
