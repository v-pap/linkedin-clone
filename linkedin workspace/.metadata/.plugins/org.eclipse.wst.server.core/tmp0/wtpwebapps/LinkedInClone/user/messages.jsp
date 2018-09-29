<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<title>WorkConnect - Messages</title>
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
            <div class="w3-col m2">
                <div class="w3-container w3-card w3-white w3-margin" style="max-height: 720px; overflow-y: scroll">
                    <br>
                    <c:forEach items="${profs}" var="prof_con">
                    <c:if test = "${prof_con.getId() == prof_message.getId()}"><span class="w3-tag w3-round-large w3-theme-d1"><br></c:if><a href="/LinkedInClone/UserMessages?id=${prof_con.getId()}">
                    <img src="/LinkedInClone/ImageServlet?id=${prof_con.getPath()}" alt="Avatar" style="width:100%" class="w3-round-large">
                    <h6>${prof_con.getName()} ${prof_con.getSurname()}</h6><c:if test = "${prof_con.getId() == prof_message.getId()}"></span></c:if>
                    </a>
                    <hr>
                    </c:forEach>
                </div>
                <!-- End Middle Column -->
            </div>
			<c:if test = "${prof_message != null}">
            <div class="w3-col m10">
                <div class="w3-container w3-card w3-white w3-margin">
                    <div class="w3-margin">
                    <a href="/LinkedInClone/ViewProfileServlet?id=${prof_message.getId()}">
                        <h3>${prof_message.getName()} ${prof_message.getSurname()}</h3>
                    </a>
                    </div>
                    <div id="messages_area" style="height: 720px; overflow-y: scroll">
                        <ul class="w3-ul">
                        	<c:forEach items="${messages_list}" var="message">
                        	<c:choose>
                        	<c:when test = "${message.getProfessional1().getId() == prof_message.getId()}">
                            <li>
                                <table style="width: 100%">
                                    <td style="vertical-align: top">
                                        <a href="/LinkedInClone/ViewProfileServlet?id=${prof_message.getId()}">
                                            <img src="/LinkedInClone/ImageServlet?id=${prof_message.getPath()}" alt="Avatar" style="width:100%" class="w3-round-large">
                                        </a>
                                    </td>
                                    <td style="width: 90%">
                                        ${message.getMessageText()}
                                        <br>
                                        <br>
                                    </td>
                                </table>
                            </li>
                            </c:when>
                            <c:otherwise>
                            <li>
                                ${message.getMessageText()}
                                <br>
                                <br>
                            </li>
                            </c:otherwise>
                            </c:choose>
                            </c:forEach>
                        </ul>
                    </div>
                    <div class="w3-padding-8">
                    	<form action="/LinkedInClone/UserMessages" method="post">
                        <table style="width:100%">
                            <td style="width: 100%">
                                <input name = "message" id="message" type="text" placeholder="Type your message." class="w3-border w3-padding"
                                    style="width:100%;" required/>
                                <input type="hidden" name="id" value="${prof_message.getId()}">
                            </td>
                            <td style="width: 50%">
                                <button type="submit" onclick="check_message();" class="w3-button w3-theme-d2">
                                    <i class="fa fa-send"></i> Send</button>
                            </td>
                            <td style="width: 50%">
                                <button type="button" onclick="location.href='/LinkedInClone/UserMessages?id=${prof_message.getId()}';" class="w3-button w3-theme-d2">
                                    <i class="fa fa-refresh"></i> Refresh</button>
                            </td>
                        </table>
                        </form>
                    </div>
                </div>
            </div>
            </c:if>
            <!-- End Middle Column -->
        </div>

    </div>
    <!-- End Grid -->
    </div>
    <!-- End Page Container -->
    </div>
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

        window.onload = function () {
            var objDiv = document.getElementById("messages_area");
            objDiv.scrollTop = objDiv.scrollHeight;
        }

        function check_message() {
            if (document.getElementById('message').value != "") {
                location.href = '/LinkedInClone/UserMessages?id=${prof_message.getId()}';
            }
        }
    </script>
</body>

</html>