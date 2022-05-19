package com.comento.practical.entity;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    private int id;

    private String task_code;
    private String task_name;

    private Timestamp create_time;
    private Timestamp update_time;
}
