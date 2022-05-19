package com.comento.practical.controller.api;

import com.comento.practical.dto.CreateRNR;
import com.comento.practical.dto.ResponseRNR;
import com.comento.practical.service.RNRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rnr")
public class RNRApiController {

    @Autowired
    private RNRService rnrService;



    @GetMapping("/select-all")
    public List<ResponseRNR> selectAllRnRJoin(){
        return rnrService.selectAllRNRJoin();
    }


    @GetMapping("/select/companyList/{manager_id}")
    public List<String> selectCompanyList(@PathVariable int manager_id){
        return rnrService.selectCompanyList(manager_id);
    }

    @GetMapping("/select/kindList/{manager_id}")
    public List<String> selectKindList(@PathVariable int manager_id){
        return rnrService.selectKindList(manager_id);
    }

    //회사 추가
    @PostMapping("/insert/company")
    public ResponseEntity insertCompany(@RequestBody String company_name){
         rnrService.insertCompany(company_name);
         return new ResponseEntity(HttpStatus.OK);
    }

    //종류 추가
    @PostMapping("/insert/kind")
    public ResponseEntity insertKind(@RequestBody String kind_name){
        rnrService.insertKind(kind_name);
        return new ResponseEntity(HttpStatus.OK);
    }


    @PostMapping("/add/company/{manager_id}")
    public ResponseEntity addCompany(@PathVariable int manager_id, @RequestBody int company_id){
        rnrService.addCompany(manager_id,company_id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping("/add/kind/{manager_id}")
    public ResponseEntity addKind(@PathVariable int manager_id, @RequestBody int kind_id){
        rnrService.addKind(manager_id,kind_id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @PostMapping("/add/task/{manager_id}")
    public ResponseEntity addTask(@PathVariable int manager_id, @RequestBody int task_id){
        rnrService.addTask(manager_id,task_id);
        return new ResponseEntity(HttpStatus.OK);
    }




}
