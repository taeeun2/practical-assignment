package com.comento.practical.service;

import com.comento.practical.entity.Task;

import java.util.List;

public interface TaskService {
    public void insertTask(String task_name);
    public List<Task> selectByName(String task_name);
    public Task selectOneTask(int id);

    public List<Task> selectAllTask();

    public void deleteTask(int id);
}
