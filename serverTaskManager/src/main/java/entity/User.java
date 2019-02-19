package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@NamedQuery(name = "User.getAll", query = "SELECT c from User c")
public class User implements Serializable {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private int password;

    @Column(name = "userName")
    private String userName;

    @Id
    @Column(name = "id")
    private String id;

    public User() { }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public int getPassword() { return password; }

    public void setPassword(int password) { this.password = password; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}
