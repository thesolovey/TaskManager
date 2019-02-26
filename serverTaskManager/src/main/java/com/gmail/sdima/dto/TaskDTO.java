package com.gmail.sdima.dto;

import java.util.Date;

public class TaskDTO {
    private String  id;

    private String name;

    private String nameByProject;

    private String idByProject;

    private String userLogin;

    private String idByUser;

    private Date dateBegin;

    private Date dateEnd;

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getNameByProject() { return nameByProject; }

    public void setNameByProject(String nameByProject) { this.nameByProject = nameByProject; }

    public String getIdByProject() { return idByProject; }

    public void setIdByProject(String idByProject) { this.idByProject = idByProject; }

    public String getUserLogin() { return userLogin; }

    public void setUserLogin(String userLogin) { this.userLogin = userLogin; }

    public String getIdByUser() { return idByUser; }

    public void setIdByUser(String idByUser) { this.idByUser = idByUser; }

    public Date getDateBegin() { return dateBegin; }

    public void setDateBegin(Date dateBegin) { this.dateBegin = dateBegin; }

    public Date getDateEnd() { return dateEnd; }

    public void setDateEnd(Date dateEnd) { this.dateEnd = dateEnd; }
}
