package com.comento.practical.entity;

import com.comento.practical.type.Position_type;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manager {
    private int id;

    private String manager_name;
    private Position_type position_type;
    private String phone_number;
    private int task_id;

    private Timestamp create_time;
    private Timestamp update_time;
}
