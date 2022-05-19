package com.comento.practical.mapper;

import com.comento.practical.dto.CreateManager;
import com.comento.practical.dto.UpdateManager;
import com.comento.practical.entity.Manager;

import java.util.List;

public interface ManagerMapper {

    public void insertManager(CreateManager.Request request);
    public List<Manager> selectAllManager();
    public Manager selectOneManager(int id);
    public List<Manager> selectByName(String manager_name);

    public void updateManager(UpdateManager.Request request);
    public void deleteManager(int id);

}
