<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<title>WorkConnect - Admin</title>
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
            <a href="/LinkedInClone/AdministratorServlet" class="w3-bar-item w3-button w3-padding-large">

                WorkConnect - Admin Control Page
            </a>
            <a href="/LinkedInClone/AdministratorServlet/logout" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-sign-out"></i>
                Log Out
            </a>
        </div>
    </div>

    <!-- Navbar on small screens -->
    <div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">
        <a href="admin.html" class="w3-bar-item w3-button w3-padding-large">Home</a>
        <a href="login.html" class="w3-bar-item w3-button w3-padding-large">Log Out</a>
    </div>

    <!-- Page Container -->
    <div class="w3-container w3-content" style="max-width:66.%;margin-top:80px">
        <!-- The Grid -->
        <div class="w3-row">

            <!-- Middle Column -->
            <div class="w3-col">
                <div class="w3-container w3-card w3-white w3-margin">
                    <table style="width: 100%">
                        <td style="width: 37%">
                            <h4>
                                <i class="fa fa-user"></i> Users</h4>
                        </td>
                        <td style="width: 17%">
                            <button type="button" onclick="unselect_all();" class="w3-button w3-theme-d2 w3-margin-right">
                                <i class="fa fa-remove"></i> Unselect All</button>
                        </td>
                        <td style="width: 23%">
                            <button type="button" class="w3-button w3-theme-d2 w3-margin-right">
                                <i class="fa fa-download"></i> Download Selected (XML)</button>
                        </td>
                        <td style="width: 23%">
                            <button type="button" class="w3-button w3-theme-d2" style="width: 100%">
                                <i class="fa fa-download"></i> Download All (XML)</button>
                        </td>
                    </table>
                </div>
                <c:forEach items="${profs}" var="prof">
			        <div class="w3-container w3-card w3-white w3-margin">
                    <table style="width: 100%">
                        <td>
                            <p class="w3-center">
                                <a href="profile_admin.html">
                                    <img src="${pageContext.request.contextPath}/images/avatar2.png" style="height:116px;width:116px" alt="Avatar">
                                </a>
                            </p>
                        </td>
                        <td class="w3-padding">
                            <h4 class="w3-center"><a href="user_profile.html" class="w3-link"><c:out value="${prof.getName()}"/> <c:out value="${prof.getSurname()}"/></a></h4>
                        </td>
                        <td>
                            <p>
                                <i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> <c:out value="${prof.getJobTitle()}"/></p>
                            <p>
                                <i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i> London, UK</p>
                            <p>
                                <i class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i> April 1, 1988</p>
                        </td>
                        <td>
                            <p>
                                <i class="fa fa-envelope-open"></i> Email: <c:out value="${prof.getEmail()}"/></p>
                            <p>
                                <i class="fa fa-phone"></i> Phone: <c:out value="${prof.getTelephone()}"/></p>
                            <p>
                                <i class="fa fa-link"></i> Website: website.com</p>
                            </p>
                        </td>
                        <td>
                            <div style="width:100%">
                                <table style="width:100%">
                                    <td style="width:100%">
                                        <label class="w3-opacity-min">Select User (XML) </label>
                                    </td>
                                    <td>
                                        <input id="check_1" class="w3-check" type="checkbox">
                                    </td>
                                </table>
                            </div>
                            <button type="button" onclick="location.href='profile_admin.html'" class="w3-button w3-theme-d2" style="width:100%">
                                <i class="fa fa-user"></i> View Profile</button>
                            <br>
                            <br>
                            <button type="button" class="w3-button w3-theme-d2" style="width:100%">
                                <i class="fa fa-download"></i> Download (XML)</button>
                        </td>
                    </table>
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
        var user_count = 4;
        // Used to toggle the menu on smaller screens when clicking on the menu button
        function openNav() {
            var x = document.getElementById("navDemo");
            if (x.className.indexOf("w3-show") == -1) {
                x.className += " w3-show";
            } else {
                x.className = x.className.replace(" w3-show", "");
            }
        }

        function unselect_all() {
            for (var i = 1; i <= user_count; i++) {
                document.getElementById("check_" + i).checked = false;
            }
        }
    </script>
</body>

</html>