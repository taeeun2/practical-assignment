package com.comento.practical.dto;

import com.comento.practical.type.Position_type;
import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseRNR {

    private String task_code;
    private String task_name;
    private String manager_name;
    private Position_type position_type;
    private String phone_number;
    private int manager_id;

    public static ResponseRNR fromJoinRNR(@NonNull JoinRNR joinRNR){
        return ResponseRNR.builder()
                .task_code(joinRNR.getTask().getTask_code())
                .task_name(joinRNR.getTask().getTask_name())
                .manager_name(joinRNR.getManager().getManager_name())
                .position_type(joinRNR.getManager().getPosition_type())
                .phone_number(joinRNR.getManager().getPhone_number())
                .manager_id(joinRNR.getManager().getId())
                .build();
    }


}
