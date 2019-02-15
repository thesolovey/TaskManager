package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "task")
@NamedQuery(name = "Task.getAll", query = "SELECT c from Task c")
public class Task implements Serializable {

    @Id
    @Column(name = "id")
    private String  id;

    @Column(name = "name")
    private String name;

    @Column(name = "nameByProject")
    private String nameByProject;

    @Column(name = "idByProject")
    private String idByProject;

    @Column(name = "userLogin")
    private String userLogin;

    @Column(name = "idByUser")
    private String idByUser;

    @Column(name = "dateBegin")
    private Date dateBegin;

    @Column(name = "dateEnd")
    private Date dateEnd;

    public String getIdByUser() { return idByUser; }

    public void setIdByUser(String idByUser) { this.idByUser = idByUser; }

    public String getUserLogin() { return userLogin; }

    public void setUserLogin(String userLogin) { this.userLogin = userLogin; }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public Date getDateBegin() {return dateBegin;}

    public void setDateBegin(Date dateBegin) {this.dateBegin = dateBegin;}

    public Date getDateEnd() {return dateEnd;}

    public void setDateEnd(Date dateEnd) {this.dateEnd = dateEnd;}

    public String getNameByProject() { return nameByProject; }

    public void setNameByProject(String nameByProject) { this.nameByProject = nameByProject; }

    public String getIdByProject() { return idByProject; }

    public void setIdByProject(String idByProject) { this.idByProject = idByProject; }
}
