package com.comento.practical.dto;

import com.comento.practical.entity.Manager;
import com.comento.practical.entity.Task;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JoinRNR {
    private Task task;
    private Manager manager;
}
