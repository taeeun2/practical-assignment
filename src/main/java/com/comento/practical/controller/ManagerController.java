package com.comento.practical.controller;

import com.comento.practical.dto.CreateManager;
import com.comento.practical.dto.UpdateManager;
import com.comento.practical.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/manager")
@Controller
public class ManagerController {

    @Autowired
    private ManagerService managerService;


    @GetMapping("/select-all")
    public String selectAllManager(Model model){
        model.addAttribute("manager_list",managerService.selectAllManager());
        return "manager/all-manager";
    }

    @GetMapping("/insert")
    public String insertManagerGet(){
        return "manager/insert-manager";
    }

    @PostMapping("/insert")
    public String insertManagerPost(CreateManager.Request request, Model model){
        managerService.insertManager(request);
        model.addAttribute("manager_list",managerService.selectAllManager());
        return "manager/all-manager";
    }

    @GetMapping("/delete/{id}")
    public String deleteManager(Model model, @PathVariable int id){
        managerService.deleteManager(id);
        model.addAttribute("manager_list",managerService.selectAllManager());
        return "manager/all-manager";
    }

    @GetMapping("/update/{id}")
    public String updateManager(Model model, @PathVariable int id){
        model.addAttribute("manager",managerService.selectOneManager(id));
        return "manager/update-manager";
    }

    @PostMapping("/update")
    public String updateManager(UpdateManager.Request request, Model model){
        managerService.updateManager(request.getId(), request);
        model.addAttribute("manager_list",managerService.selectAllManager());
        return "manager/all-manager";
    }

}
