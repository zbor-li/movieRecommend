package ysu.ldr.mapper;

import ysu.ldr.pojo.Manager;

public interface ManagerMapper {
    public Manager selectManagerInfo(String managerName);

    public Integer getManagerIdByName(String managerName);
}
