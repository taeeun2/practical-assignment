package com.comento.practical.serviceImpl;

import com.comento.practical.dto.CreateRNR;
import com.comento.practical.dto.JoinRNR;
import com.comento.practical.dto.ResponseRNR;
import com.comento.practical.entity.Company;
import com.comento.practical.entity.Kind;
import com.comento.practical.exception.PracticalErrorCode;
import com.comento.practical.exception.PracticalException;
import com.comento.practical.mapper.RNRMapper;
import com.comento.practical.service.RNRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;

import static com.comento.practical.exception.PracticalErrorCode.*;

@Service
public class RNRServiceImpl implements RNRService {

    @Autowired
    private RNRMapper rnrMapper;
    @Autowired
    private ManagerServiceImpl managerService;
    @Autowired
    private TaskServiceImpl taskService;

    @Override
    public List<ResponseRNR> selectAllRNRJoin() {

        return rnrMapper.selectAllRNRJoin().stream()
                .map(ResponseRNR :: fromJoinRNR).collect(Collectors.toList());
    }

    @Override
    public ResponseRNR selectOneRNRJoin(int manager_id) {

        //validation
        managerService.selectOneManager(manager_id);

        return ResponseRNR.fromJoinRNR(rnrMapper.selectOneRNRJoin(manager_id));
    }

    @Override
    @Transactional
    public void insertCompany(String company_name) {
        //validation
        if(rnrMapper.selectCompanyByName(company_name)!=null)
            throw new PracticalException(DUPLICATE_COMPANY);
        rnrMapper.insertCompany(company_name);
    }

    @Override
    @Transactional
    public void insertKind(String kind_name) {
        //validation
        if(rnrMapper.selectKindByName(kind_name)!=null)
            throw new PracticalException(DUPLICATE_KIND);
        rnrMapper.insertKind(kind_name);
    }

    @Override
    @Transactional
    public void addCompany(int manager_id, int company_id) {
        //validation
        managerService.selectOneManager(manager_id);
        if(rnrMapper.selectOneCompany(company_id)==null)
            throw new PracticalException(NO_COMPANY);

        rnrMapper.insertCompanyIntoRNR(manager_id,company_id);
    }

    @Override
    @Transactional
    public void addKind(int manager_id, int kind_id) {
        //validation
        managerService.selectOneManager(manager_id);
        if(rnrMapper.selectOneKind(kind_id)==null)
            throw new PracticalException(NO_KIND);

        rnrMapper.insertKindIntoRNR(manager_id,kind_id);
    }

    @Override
    @Transactional
    public void addTask(int manager_id, int task_id) {
        //validation
        managerService.selectOneManager(manager_id);
        taskService.selectOneTask(task_id);

        rnrMapper.insertTaskIntoRNR(manager_id,task_id);
    }

    @Override
    public List<String> selectCompanyList(int manager_id) {
        //validation
        managerService.selectOneManager(manager_id);

        return rnrMapper.selectCompanyList(manager_id);
    }

    @Override
    public List<String> selectKindList(int manager_id) {
        //validation
        managerService.selectOneManager(manager_id);

        return rnrMapper.selectKindList(manager_id);
    }

    @Override
    public List<Company> selectAllCompany() {
        return rnrMapper.selectAllCompany();
    }

    @Override
    public List<Kind> selectAllKind() {
            return rnrMapper.selectAllKind();
    }
}
