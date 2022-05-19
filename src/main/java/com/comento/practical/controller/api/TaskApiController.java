package com.comento.practical.controller.api;

import com.comento.practical.entity.Task;
import com.comento.practical.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskApiController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/insert")
    public ResponseEntity insertTask(@RequestBody String task_name){
        taskService.insertTask(task_name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/selectByName/{task_name}")
    public List<Task> selectByName(@PathVariable String task_name){
        return taskService.selectByName(task_name);
    }

    @GetMapping("/select/{id}")
    public Task selectOneTask(@PathVariable int id){
        return taskService.selectOneTask(id);
    }

    @GetMapping("/select-all")
    public List<Task> selectAllTask(){
        return taskService.selectAllTask();
    }

    @GetMapping("/delete/{id}")
    public void deleteTask(@PathVariable int id){
        taskService.deleteTask(id);
    }

}
