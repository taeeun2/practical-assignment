package com.comento.practical.mapper;

import com.comento.practical.dto.CreateRNR;
import com.comento.practical.dto.JoinRNR;
import com.comento.practical.entity.Company;
import com.comento.practical.entity.Kind;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RNRMapper {
//    public void insertRNR(CreateRNR.Request request);
    public List<JoinRNR> selectAllRNRJoin();

    public JoinRNR selectOneRNRJoin(int manager_id);
    public void insertCompany(String company_name);

    public void insertKind(String kind_name);

    public void insertCompanyIntoRNR(int manager_id, int company_id);
    public void insertKindIntoRNR(int manager_id, int kind_id);
    public void insertTaskIntoRNR(int manager_id, int task_id);


    public String selectOneCompany(int company_id);
    public String selectOneKind(int kind_id);


    public List<String> selectCompanyList(int manager_id);
    public List<String> selectKindList(int manager_id);

    public List<Company> selectAllCompany();

    public List<Kind> selectAllKind();

    public Company selectCompanyByName(String company_name);
    public Kind selectKindByName(String kind_name);

    public String checkDuplicateCompany(int manager_id, int company_id);
    public String checkDuplicateKind(int manager_id, int kind_id);
}
