package com.gmail.sdima9999.entity;

import java.util.ArrayList;
import java.util.Date;

public class Task extends ArrayList<Task> {

    private String name;

    private String  id;

    private Date dateBegin;

    private Date dateEnd;

    private String nameByProject;

    private String userName;

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

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }
}
