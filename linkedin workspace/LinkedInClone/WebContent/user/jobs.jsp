<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>WorkConnect - Network</title>
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
                <div class="w3-row-padding">
                    <div class="w3-col m12">
                        <div class="w3-card w3-white">
                            <div class="w3-container w3-padding">
                            	<form action="/LinkedInClone/UserJobs/post" method="post" enctype='multipart/form-data'>
                                <div class="w3-padding-8">
                                    <input name="job_title" id="title" type="text" placeholder="Job Title" onkeyup="check_form(this.id);"
                                        class="w3-border w3-padding" style="width:100%;" required />
                                </div>
                                <div class="w3-padding-8">
                                    <input name="job_description" id="post" type="text" placeholder="Post your own Job Offer" class="w3-border w3-padding"
                                        style="width:100%;" required/>
                                </div>
                                <table>
                                    <td>
                                        <button type="submit" onclick="check_post();" class="w3-button w3-theme-d2">
                                            <i class="fa fa-pencil"></i> Post</button>
                                    </td>
                                    <td>
                                        <button type="button" onclick="image_upload();" class="w3-button w3-theme-d2">
                                            <i class="fa fa-photo "></i> Photo</button>
                                        <input name="image" id='upload_button' type='file' onchange="image_pick();" hidden />
                                    </td>
                                    <td id="img_picked" class="w3-opacity">
                                    </td>
                                    <td>
                                        <input id="error_message" class="w3-opacity-min" type="text" value="" style="border: 0;background-color: inherit; color:red;font-weight: bold"
                                            readonly>
                                    </td>
                                </table>
                                </form>
                                <div class="w3-padding-8 w3-opacity-min">
                                    <a href="/LinkedInClone/UserJobs/view" class="w3-link">
                                        <i class="fa fa-list"></i> View your current Job Offers
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

				<c:forEach items="${jobs_list}" var="job">
                <div class="w3-container w3-card w3-white w3-margin">
                    <br>
                    <h4>${job.getJobTitle()}</h4>
                    <p>Submitted by <a href="/LinkedInClone/ViewProfileServlet?id=${job.getProfessional().getId()}" class="w3-link">${job.getProfessional().getName()} ${job.getProfessional().getSurname()}</a> </p>
                    <hr class="w3-clear">
                    <p>${job.getText()}</p>
                    <img src="/LinkedInClone/ImageServlet?id=${job.getPath()}" style="width:100%" alt="Northern Lights" class="w3-margin-bottom">
                    <c:choose>
                    <c:when test = "${prof.alreadyApplied(job.getJobId()) == false}">
                    <form action="/LinkedInClone/UserJobs/apply" method="post">
                    <button type="submit" class="w3-button w3-theme-d2 w3-margin-bottom">
                        <i class="fa fa-send"></i> Apply</button>
                    <input type="hidden" name="job_id" value="${job.getJobId()}">
                    </form>
                    </c:when>
                    <c:otherwise>
                    <button type="button" disabled="true" class="w3-button w3-theme-d2 w3-margin-bottom">
                        <i class="fa fa-send"></i> Already Applied</button>
                    </c:otherwise>
                    </c:choose>
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

        function image_upload() {
            document.getElementById('upload_button').click();
        }

        function image_pick() {
            var selected_image = document.getElementById('upload_button').files[0];
            document.getElementById('img_picked').innerHTML = "Selected image: " + selected_image.name;
        }
        
        function check_form(id) {
            document.getElementById(id).setCustomValidity("");
            if (document.getElementById(id).checkValidity() == false) {
                document.getElementById(id).setCustomValidity("Invalid field.");
                document.getElementById('error_message').value = "Missing required fields.";
            }
            else {
                document.getElementById(id).setCustomValidity("");
                document.getElementById('error_message').value = "";
            }
        }

        function check_post() {
            var error = false;
            if (document.getElementById('title').value == "") {
                document.getElementById('title').setCustomValidity("Invalid field.");
                document.getElementById('error_message').value = "Missing required fields.";
                error = true;
            }
            else {
                document.getElementById('title').setCustomValidity("");
            }
            if (document.getElementById('post').value == "") {
                document.getElementById('post').setCustomValidity("Invalid field.");
                document.getElementById('error_message').value = "Missing required fields.";
                error = true;
            }
            else {
                document.getElementById('post').setCustomValidity("");
            }
            if (error == false) {
                document.getElementById('error_message').value = "";
            }
        }
    </script>
</body>

</html>