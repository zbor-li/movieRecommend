package ysu.ldr.pojo;

import java.util.Date;

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String gender;
    private Integer age;
    private Boolean commentStatus;
    private Date registrationDate;
    private String preference;

    public User() {
    }

    public User(Integer userId, String userName, String password, String gender, Integer age, Boolean commentStatus, Date registrationDate, String preference) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.age = age;
        this.commentStatus = commentStatus;
        this.registrationDate = registrationDate;
        this.preference = preference;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Boolean commentStatus) {
        this.commentStatus = commentStatus;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", commentStatus=" + commentStatus +
                ", registrationDate=" + registrationDate +
                ", preference='" + preference + '\'' +
                '}';
    }
}
