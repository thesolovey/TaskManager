<%@ page import="com.gmail.sdima.entity.Project" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>PROJECT DELETE</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-left-align">
            <h1>PROJECT DELETE PAGE</h1>
        </div>

        <div class="w3-container w3-left w3-margin-bottom w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-light-blue">
                    <h2>Project Delete</h2>
            </div>
          <%
              Project project = (Project) session.getAttribute("projects");
                 if (project != null) {
          %>
                  <ul class=\"w3-ul\">
                      <li class="w3-hover-sand">Project Name:<%=project.getName()%></li>
                      <li class="w3-hover-sand">Project ID:<%=project.getId()%></li>
                  </ul>
               <%}%>
            </div>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/userMainMenu'"><i class="fa fa-home"></i> Back to User Main Page</button>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <button class="w3-btn w3-round-large" onclick="location.href='/'"><i class="fa fa-home"></i> Back to Main-Menu</button>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-left-align w3-padding">
            <form method="post">
                <button type="submit" name="projectId" value="<%=project.getId()%>" class="w3-btn w3-round-large w3-red">YES DELETE PROJECT <i class="fa fa-trash"></i></button>
            </form>
        </div>
    </body>
</html>