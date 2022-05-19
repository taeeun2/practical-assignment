package com.comento.practical.controller.api;

import com.comento.practical.dto.CreateManager;
import com.comento.practical.dto.UpdateManager;
import com.comento.practical.entity.Manager;
import com.comento.practical.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/manager")
public class ManagerApiController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/insert")
    public ResponseEntity insertManager(@Valid @RequestBody CreateManager.Request request){
        managerService.insertManager(request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/select-all")
    public List<Manager> selectAllManager(){
        return managerService.selectAllManager();
    }

    @GetMapping("/select/{id}")
    public Manager selectOneManager(@PathVariable int id){
        return managerService.selectOneManager(id);
    }

    @GetMapping("/selectByName/{manager_name}")
    public List<Manager> selectByName(@PathVariable String manager_name){
        return managerService.selectByName(manager_name);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity updateManager(
            @PathVariable int id,@Valid @RequestBody UpdateManager.Request request){

        managerService.updateManager(id,request);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteManager(
            @PathVariable int id){
        managerService.deleteManager(id);
        return new ResponseEntity(HttpStatus.OK);
    }



}
