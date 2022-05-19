package com.comento.practical.service;

import com.comento.practical.dto.CreateManager;
import com.comento.practical.dto.UpdateManager;
import com.comento.practical.entity.Manager;
import lombok.NonNull;

import java.util.List;

public interface ManagerService {
    public void insertManager(@NonNull CreateManager.Request request);
    public List<Manager> selectAllManager();
    public Manager selectOneManager(int id);
    public void updateManager(int id, UpdateManager.Request request);
    public void deleteManager(int id);
    public List<Manager> selectByName(String manager_name);
}
