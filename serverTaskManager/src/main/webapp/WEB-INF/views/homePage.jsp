<!DOCTYPE html>
<html>

<head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

    <body>

          <!-- Sidebar -->
          <div class="w3-sidebar w3-bar-block w3-border-right" style="display:none" id="mySidebar">
            <button onclick="w3_close()" class="w3-bar-item w3-large">Close &times;</button>

            <a href="registration" class="w3-bar-item w3-button">Registration</a>
            <a href="authorization" class="w3-bar-item w3-button">Sign in</a>

            <a href="projectList" class="w3-bar-item w3-button">Project List</a>
            <a href="taskList" class="w3-bar-item w3-button">task List</a>

          </div>

          <!-- Page Content -->
          <div class="w3-teal">
            <button class="w3-button w3-teal w3-xlarge" onclick="w3_open()"><i class="fa fa-bars"></i></button>
            <div class="w3-container">
              <h1>WELLCOME TO TASK MANAGER</h1>
            </div>
          </div>


          <div class="w3-container">
          <p>If you want Start TaskManager, you must click on the "hamburger" icon (top left) to open it.</p>
          </div>

          <script>
          function w3_open() {
            document.getElementById("mySidebar").style.display = "block";
          }

          function w3_close() {
            document.getElementById("mySidebar").style.display = "none";
          }
          </script>
    </body>
</html>