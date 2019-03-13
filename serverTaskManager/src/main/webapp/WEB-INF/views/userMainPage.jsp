<%@ page import="com.gmail.sdima.entity.Project" %>
<%@ page import="com.gmail.sdima.entity.Task" %>
<%@ page import="com.gmail.sdima.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>USER OPEN</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
            <h1>USER MAIN PAGE</h1>
        </div>

        <div class="w3-container w3-left w3-margin-bottom w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-light-blue">
                <%
                    User user = (User) session.getAttribute("user");
                    if (user != null) {
                %>
                    <h2>User Name: <%=user.getUserName()%></h2>
                    <h2>User ID: <%=user.getId()%></h2>
                    <%}%>
                </div>
                <%
                        List<Project> projectList = (List<Project>) session.getAttribute("projectList");
                        if (projectList != null)
                        for (Project project: projectList) {
                 %>
                        <h4>Project Name:   <%=project.getName()%></h4>
                    <%}%>
                      <ul class=\"w3-ul\">

                          <%
                          List<String> taskList = (List<String>) session.getAttribute("tasks");
                          if (taskList != null)
                          for (String task: taskList)
                          {
                          %>
                               <ul class=\"w3-ul\">
                                  <li>TASKS FOR THIS PROJECT:</li>
                                  <li>Task:   <%=task%></li>


                               </ul>

                      </ul>
                    <%}%>

            </div>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/projectList'"><i class="fa fa-search"></i> Project List</button>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/taskList'"><i class="fa fa-search"></i> Task List</button>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/'"><i class="fa fa-home"></i> Back to Main-Menu</button>
        </div>

    </body>
</html>