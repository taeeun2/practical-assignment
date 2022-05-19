package com.comento.practical.controller;

import com.comento.practical.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/task")
@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/select-all")
    public String selectAllTask(Model model){
        model.addAttribute("task_list",taskService.selectAllTask());
        return "task/all-task";
    }

    @GetMapping("/insert")
    public String insertTask(){
        return "task/insert-task";
    }

    @PostMapping("/insert")
    public String insertTask(Model model, String task_name){
        taskService.insertTask(task_name);
        model.addAttribute("task_list",taskService.selectAllTask());
        return "task/all-task";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(Model model, @PathVariable int id){
        taskService.deleteTask(id);
        model.addAttribute("task_list",taskService.selectAllTask());
        return "task/all-task";
    }
}
