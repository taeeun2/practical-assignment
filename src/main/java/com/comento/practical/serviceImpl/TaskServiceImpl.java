package com.comento.practical.serviceImpl;

import com.comento.practical.entity.Manager;
import com.comento.practical.entity.Task;
import com.comento.practical.exception.PracticalException;
import com.comento.practical.mapper.TaskMapper;
import com.comento.practical.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.comento.practical.exception.PracticalErrorCode.*;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskMapper taskMapper;
    @Override
    @Transactional
    public void insertTask(String task_name) {

        //ID 생성
        int id = getTaskId();
        taskMapper.insertTask(id,task_name);
        //업무 코드 생성
        taskMapper.updateTaskCode(id);
    }

    @Override
    public List<Task> selectByName(String task_name) {
        return taskMapper.selectByName(task_name);
    }

    @Override
    public Task selectOneTask(int id) {
        return getTaskById(id);
    }

    @Override
    public List<Task> selectAllTask() {
        return taskMapper.selectAllTask();
    }

    @Override
    @Transactional
    public void deleteTask(int id) {
        taskMapper.deleteTask(id);
    }

    //ID 생성
    private int getTaskId() {
        int id = 1;
        if(!taskMapper.selectTask().isEmpty()) {
            id = taskMapper.selectLastId() + 1;
        }
        return id;
    }


    public Task getTaskById(int id) {
        Task task = taskMapper.selectOneTask(id);
        if(task==null)
            throw new PracticalException(NO_TASK);
        return task;
    }


}
