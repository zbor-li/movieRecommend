package ysu.ldr.service;

public interface ManagerService {
    public Boolean isLogin(String managerName, String password);
    public Integer getManagerIdByName(String managerName);
}
