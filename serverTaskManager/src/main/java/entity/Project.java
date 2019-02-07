package entity;

import java.io.Serializable;

public class Project implements Serializable {

    private String name;

    private String id;

    private String userName;

    private String userLogin;

    private String userId;

    public String getUserId() { return userId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getUserLogin() { return userLogin; }

    public void setUserLogin(String userLogin) { this.userLogin = userLogin; }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }
}
