package com.comento.practical.dto;

import com.comento.practical.type.Position_type;
import lombok.*;

public class CreateRNR {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private int task_id;
        private int manager_id;

        private int company_id;
        private int kind_id;
    }



}
