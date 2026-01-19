package ysu.ldr.pojo.res;

import ysu.ldr.pojo.User;

import java.util.List;

public class AllUsersRes {
    private List<User> userList;
    private Integer total;

    public AllUsersRes() {
    }

    public AllUsersRes(List<User> userList, Integer total) {
        this.userList = userList;
        this.total = total;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "AllUsersRes{" +
                "userList=" + userList +
                ", total=" + total +
                '}';
    }
}
