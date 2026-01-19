package ysu.ldr.pojo;

public class Manager {
    private Integer managerId;
    private String managerName;
    private String password;

    public Manager() {
    }

    public Manager(Integer managerId, String managerName, String password) {
        this.managerId = managerId;
        this.managerName = managerName;
        this.password = password;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
