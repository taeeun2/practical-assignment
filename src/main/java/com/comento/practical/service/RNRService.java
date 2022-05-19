package com.comento.practical.service;

import com.comento.practical.dto.CreateRNR;
import com.comento.practical.dto.JoinRNR;
import com.comento.practical.dto.ResponseRNR;
import com.comento.practical.entity.Company;
import com.comento.practical.entity.Kind;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RNRService {

    public List<ResponseRNR> selectAllRNRJoin();
    public ResponseRNR selectOneRNRJoin(int manager_id);
    public void insertCompany(String company_name);

    public void insertKind(String kind_name);

    public void addCompany(int manager_id, int company_id);

    public void addKind(int manager_id, int kind_id);

    public void addTask(int manager_id, int task_id);

    public List<String> selectCompanyList(int manager_id);
    public List<String> selectKindList(int manager_id);
    public List<Company> selectAllCompany();

    public List<Kind> selectAllKind();
}
