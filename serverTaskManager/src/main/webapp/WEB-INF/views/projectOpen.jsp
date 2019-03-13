<%@ page import="com.gmail.sdima.entity.Project" %>
<%@ page import="com.gmail.sdima.entity.Task" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>PROJECT OPEN</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
            <h1>PROJECT OPEN PAGE</h1>
        </div>

        <div class="w3-container w3-left w3-margin-bottom w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-light-blue">
                    <h2>Project</h2>
                </div>
                <%
                        Project project = (Project) session.getAttribute("projects");
                        if (project != null) {
                 %>
                      <ul class=\"w3-ul\">
                          <li class="w3-hover-sand">Project Name:<%=project.getName()%></li>

                          <%}%>

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
            <button class="w3-btn w3-round-large" onclick="location.href='/userMainPage'"><i class="fa fa-home"></i> Back to User Main Page</button>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/'"><i class="fa fa-home"></i> Back to Main-Menu</button>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <form method="post">
                <button type="submit" name="projectId"  class="w3-btn w3-round-large w3-red" onclick="location.href='/projectDelete'">to Delete Project <i class="fa fa-trash"></i></button>
            </form>
        </div>
    </body>
</html>