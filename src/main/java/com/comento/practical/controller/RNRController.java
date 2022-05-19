package com.comento.practical.controller;

import com.comento.practical.service.ManagerService;
import com.comento.practical.service.RNRService;
import com.comento.practical.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/rnr")
@Controller
public class RNRController {

    @Autowired
    private RNRService rnrService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private TaskService taskService;

    @GetMapping("/select-all")
    public String selectAllRnRJoin(Model model){
        model.addAttribute("rnr_list",rnrService.selectAllRNRJoin());
        return "rnr/all-rnr";
    }

    @GetMapping("/select/{manager_id}")
    public String selectOneRNR(Model model, @PathVariable int manager_id){
        model.addAttribute("rnr", rnrService.selectOneRNRJoin(manager_id));
        model.addAttribute("company_list",rnrService.selectCompanyList(manager_id));
        model.addAttribute("kind_list",rnrService.selectKindList(manager_id));
        return "rnr/detail-rnr";
    }

    @GetMapping("/insert")
    public String insertRNR(Model model){
        model.addAttribute("manager_list",managerService.selectAllManager());
        model.addAttribute("task_list",taskService.selectAllTask());
        return "rnr/insert-rnr";
    }

    @PostMapping("/insert")
    public String insertRNR(int manager_id, int task_id, Model model){
        rnrService.addTask(manager_id,task_id);
        model.addAttribute("rnr_list",rnrService.selectAllRNRJoin());
        return "rnr/all-rnr";
    }

    @GetMapping("/insert/company/{manager_id}")
    public String insertCompany(@PathVariable int manager_id, Model model){
        model.addAttribute("manager_id",manager_id);
        model.addAttribute("company_list",rnrService.selectAllCompany());
        return "rnr/insert-company";
    }

    @PostMapping("/insert/company")
    public String insertCompany(int company_id, int manager_id, Model model){
        rnrService.addCompany(manager_id,company_id);
        model.addAttribute("rnr", rnrService.selectOneRNRJoin(manager_id));
        model.addAttribute("company_list",rnrService.selectCompanyList(manager_id));
        model.addAttribute("kind_list",rnrService.selectKindList(manager_id));
        return "rnr/detail-rnr";
    }

    @GetMapping("/insert/kind/{manager_id}")
    public String insertKind(@PathVariable int manager_id, Model model){
        model.addAttribute("manager_id",manager_id);
        model.addAttribute("kind_list",rnrService.selectAllKind());
        return "rnr/insert-kind";
    }

    @PostMapping("/insert/kind")
    public String insertKind(int kind_id, int manager_id, Model model){
        rnrService.addKind(manager_id,kind_id);
        model.addAttribute("rnr", rnrService.selectOneRNRJoin(manager_id));
        model.addAttribute("company_list",rnrService.selectCompanyList(manager_id));
        model.addAttribute("kind_list",rnrService.selectKindList(manager_id));
        return "rnr/detail-rnr";
    }
}
