<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>WorkConnect - Notifications</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/w3.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/w3-theme-blue-grey.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/fonts/open_sans.ttf" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css">
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
            <div class="w3-col">
            	<c:forEach items="${jobs_list}" var="job" varStatus="loop">
                <div class="w3-container w3-card w3-white w3-margin">
                    <br>
                    <h4>${job.getJobTitle()}</h4>
                    <hr class="w3-clear">
                    <p>${job.getText()}</p>
                    <img src="/LinkedInClone/ImageServlet?id=${job.getPath()}" style="width:100%" alt="Northern Lights" class="w3-margin-bottom">
                    <button id="hide_${loop.count}" type="button" onclick="hide_show_applicants(this.id);" class="w3-button w3-theme-d2 w3-margin-bottom">
                        <i class="fa fa-eye-slash"></i> Hide Applicants</button>
                    <div id="applicants_${loop.count}">
                        <table style="width:100%">
                        	<c:forEach items="${job.getProfessionals()}" var="job_prof">
                            <tr>
                                <td>
                                    <a href="/LinkedInClone/ViewProfileServlet?id=${job_prof.getId()}">
                                        <img src="/LinkedInClone/ImageServlet?id=${job_prof.getPath()}" alt="Avatar" class="w3-left w3-round-large w3-margin-right w3-margin-bottom"
                                            style="width:60px">
                                    </a>
                                </td>
                                <td style="width: 100%">
                                    <b><a href="/LinkedInClone/ViewProfileServlet?id=${job_prof.getId()}" class="w3-link">${job_prof.getName()} ${job_prof.getSurname()}</a></b> has applied
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
				</c:forEach>
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

        function hide_show_applicants(id) {
            var id_num = id.split("_")[1];
            var applicants_div_id = "applicants_%num%".replace("%num%", id_num);
            if (document.getElementById(applicants_div_id).style.display != "none") {
                document.getElementById(applicants_div_id).style.display = "none";
                document.getElementById(id).innerHTML = '<i class="fa fa-eye"></i> Show Applicants';
            }
            else {
                document.getElementById(applicants_div_id).style.display = "inline";
                document.getElementById(id).innerHTML = '<i class="fa fa-eye-slash"></i> Hide Applicants';
            }
        }
    </script>
</body>

</html>