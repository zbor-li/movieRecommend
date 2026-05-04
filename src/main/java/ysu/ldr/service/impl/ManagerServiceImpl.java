package ysu.ldr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ysu.ldr.mapper.ManagerMapper;
import ysu.ldr.pojo.Manager;
import ysu.ldr.service.ManagerService;


@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Boolean isLogin(String managerName, String password) {
        Manager manager = managerMapper.selectManagerInfo(managerName);
        if(manager == null) return false;
        return manager.getPassword().equals(password);
    }

    @Override
    public Integer getManagerIdByName(String managerName) {
        return managerMapper.getManagerIdByName(managerName);
    }
}
