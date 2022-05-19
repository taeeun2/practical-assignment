package com.comento.practical.serviceImpl;

import com.comento.practical.dto.CreateManager;
import com.comento.practical.dto.UpdateManager;
import com.comento.practical.entity.Manager;
import com.comento.practical.exception.PracticalErrorCode;
import com.comento.practical.exception.PracticalException;
import com.comento.practical.mapper.ManagerMapper;
import com.comento.practical.service.ManagerService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.comento.practical.exception.PracticalErrorCode.*;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Override
    @Transactional
    public void insertManager(@NonNull CreateManager.Request request) {
        managerMapper.insertManager(request);
    }

    @Override
    public List<Manager> selectAllManager() {
        return managerMapper.selectAllManager();
    }

    @Override
    public Manager selectOneManager(int id) {
        return getManagerById(id);
    }

    private Manager getManagerById(int id) {
        Manager manager = managerMapper.selectOneManager(id);
        if(manager==null)
            throw new PracticalException(NO_MANAGER);
        return manager;
    }

    @Override
    @Transactional
    public void updateManager(int id, UpdateManager.Request request) {
        //validation
        getManagerById(id);
        request.setId(id);

        managerMapper.updateManager(request);
    }

    @Override
    @Transactional
    public void deleteManager(int id) {
        //validation
        getManagerById(id);

        managerMapper.deleteManager(id);
    }

    @Override
    public List<Manager> selectByName(String manager_name) {
        if(managerMapper.selectByName(manager_name).isEmpty())
            throw new PracticalException(NO_MANAGER);
        return managerMapper.selectByName(manager_name);
    }

}
