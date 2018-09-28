<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<title>WorkConnect - Home</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/w3-theme-blue-grey.css">
<link rel="stylesheet" href="fonts/open_sans.ttf" />
<link rel="stylesheet" href="css/font-awesome.min.css">
<style>
    html,
    body,
    h1,
    h2,
    h3,
    h4,
    h5 {
        font-family: "Open Sans", sans-serif
    }
</style>

<body class="w3-theme-l5">
    <!-- Navbar -->
    <div class="w3-top">
        <div class="w3-bar w3-theme-d3 w3-left-align w3-large">
            <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-large" href="javascript:void(0);"
                onclick="openNav()">
                <i class="fa fa-bars"></i>
            </a>
            <a href="/LinkedInClone/UserServlet" class="w3-bar-item w3-button w3-padding-large">

                WorkConnect
            </a>
            <a href="/LinkedInClone/UserServlet/logout" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-sign-out"></i>
                Log Out
            </a>
            <a href="/LinkedInClone/UserSettings" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-gear"></i>
                Settings
            </a>
            <a href="/LinkedInClone/UserProfile" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-user"></i>
                My Profile
            </a>
            <a href="/LinkedInClone/UserNotifications" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-bell"></i>
                Notifications
            </a>
            <a href="/LinkedInClone/UserMessages" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-envelope"></i>
                Messages
            </a>
            <a href="/LinkedInClone/UserJobs" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-list"></i>
                Jobs
            </a>
            <a href="/LinkedInClone/UserNetwork" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-globe"></i>
                Network
            </a>
            <a href="/LinkedInClone/UserServlet" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-home"></i>
                Home
            </a>
        </div>
    </div>

    <!-- Navbar on small screens -->
    <div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
        <a href="/LinkedInClone/UserServlet" class="w3-bar-item w3-button w3-padding-large">Home</a>
        <a href="/LinkedInClone/UserNetwork" class="w3-bar-item w3-button w3-padding-large">Network</a>
        <a href="/LinkedInClone/UserJobs" class="w3-bar-item w3-button w3-padding-large">Jobs</a>
        <a href="/LinkedInClone/UserMessages" class="w3-bar-item w3-button w3-padding-large">Messages</a>
        <a href="/LinkedInClone/UserNotifications" class="w3-bar-item w3-button w3-padding-large">Notifications</a>
        <a href="/LinkedInClone/UserProfile" class="w3-bar-item w3-button w3-padding-large">My Profile</a>
        <a href="/LinkedInClone/UserSettings" class="w3-bar-item w3-button w3-padding-large">Settings</a>
        <a href="/LinkedInClone/UserServlet/logout" class="w3-bar-item w3-button w3-padding-large">Log Out</a>
    </div>

    <!-- Page Container -->
    <div class="w3-container w3-content" style="max-width:66.%;margin-top:80px">
        <!-- The Grid -->
        <div class="w3-row">

            <!-- Middle Column -->
            <div class="w3-col m4">

                <div class="w3-container w3-card w3-white w3-margin">
                    <br>
                    <img src="ImageServlet?id=${prof.getPath()}" alt="Avatar" style="width:100%" class="w3-round-large w3-margin-bottom">
                    <h4>${prof.getName()} ${prof.getSurname()}</h4>
                    <hr class="w3-clear">
                    <p>${prof.getJobTitle()}</p>
                    <hr class="w3-clear">
                    <h4>Contact Info</h4>
                    <p>
                        <i class="fa fa-envelope-open"></i> Email: ${prof.getEmail()}</p>
                    <p>
                        <i class="fa fa-phone"></i> Phone: ${prof.getTelephone()}</p>
                    </p>
                    <p><i class="fa fa-user"></i>
                        <a href="/LinkedInClone/UserNetwork" class="w3-link"> View Network </a>
                    </p>
                </div>

                <!-- End Middle Column -->
            </div>

            <div class="w3-col m8">
                <div class="w3-container w3-card w3-white w3-margin">
                    <h4>Work Experience</h4>
                    <ul style="padding-left: 16px">
                    <c:forEach items="${prof.getExperiences()}" var="experience">
                        <li><b>${experience.getTitle()}</b> <i style="float:right">${experience.getFrom()} - ${experience.getTo()}</i>
                            <br>${experience.getDescription()}
                            <br>
                            <br>
                        </li>
                    </c:forEach>
                    </ul>
                    <hr class="w3-clear">
                    <h4>Education</h4>
                    <ul style="padding-left: 16px">
                    <c:forEach items="${prof.getEducations()}" var="education">
                        <li><b>${education.getTitle()}</b> <i style="float:right;">${education.getFrom()} - ${education.getTo()}</i>
                            <br>${education.getDescription()}
                            <br>
                            <br>
                        </li>
                    </c:forEach>
                    </ul>
                    <hr class="w3-clear">
                    <h4>Skills</h4>
                    <p>
                    <c:forEach items="${prof.getSkills()}" var="skill">
                        <span class="w3-tag w3-small w3-theme">${skill.getId().getDescription()}</span>
                    </c:forEach>
                    </p>
                    <button type="button" onclick="location.href='/LinkedInClone/UserProfile/edit'" class="w3-button w3-theme-d2 w3-margin-bottom">
                        <i class="fa fa-edit"></i> Edit</button>
                </div>

                <!-- End Middle Column -->
            </div>

        </div>
        <!-- End Grid -->
    </div>
    <!-- End Page Container -->
    </div>
    <br>
    <br>
    <br>
    <!-- Footer -->
    <footer class="w3-container w3-theme-d5">
        <table class="w3-opacity-min" style="width:100%">
            <td>
                <h5>WorkConnect</h5>
            </td>
            <td style="float:right">
                <p>Made by Vasileios Papavasileiou & Vasileios Sakkas - Powered by
                    <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a>
                </p>
            </td>
        </table>
    </footer>

    <script>
        // Used to toggle the menu on smaller screens when clicking on the menu button
        function openNav() {
            var x = document.getElementById("navDemo");
            if (x.className.indexOf("w3-show") == -1) {
                x.className += " w3-show";
            } else {
                x.className = x.className.replace(" w3-show", "");
            }
        }

        function convert_date() {
        	var exp_from = <c:out value='${experience.getFrom()}'/>;
        	window.alert(exp_from);
            if (exp_from == null) {
            	document.getElementById('exp_from').innerHTML = "Now";
                return;
            }
            var d_list = current_date.split("-");
            var d = new Date(date_list[0], date_list[1]);
            var d_string_list = d.toDateString().split(" ");
            var d_string = d_string_list[1].concat(" ", d_string_list[3]);
        	document.getElementById('exp_from').innerHTML = "fig";

            //return d_string;
        }
    </script>
</body>

</html>