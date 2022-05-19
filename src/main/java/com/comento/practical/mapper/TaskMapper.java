package com.comento.practical.mapper;

import com.comento.practical.entity.Task;

import java.util.List;

public interface TaskMapper {
    public void updateTaskCode(int id);
    public void insertTask(int id,String task_name);
    public int selectLastId();

    public List<Task> selectTask();
    public List<Task> selectByName(String task_name);
    public Task selectOneTask(int id);
    public List<Task> selectAllTask();

    public void deleteTask(int id);
}
