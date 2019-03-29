package com.gmail.sdima.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
@NamedQuery(name = "User.getAll", query = "SELECT c from User c")
public class User implements Serializable {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "userName")
    private String userName;

    @Id
    @Column(name = "id")
    private String id;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
//    private Set<UserRole> authorities = new HashSet<>();

    public User() { }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }
}
