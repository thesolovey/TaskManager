package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "project")
public class Project implements Serializable {

    @Column(name = "name")
    private String name;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "userName")
    private String userName;

    @Column(name = "userLogin")
    private String userLogin;

    @Column(name = "userId")
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
