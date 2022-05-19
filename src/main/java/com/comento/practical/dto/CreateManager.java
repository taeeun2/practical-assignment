package com.comento.practical.dto;

import com.comento.practical.type.Position_type;
import lombok.*;

import javax.validation.constraints.NotNull;


public class CreateManager {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        @NotNull
        private String manager_name;
        @NotNull
        private Position_type position_type;
        @NotNull
        private String phone_number;
    }


}
