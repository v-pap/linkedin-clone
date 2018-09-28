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
        <a href="/LinkedInClone/AdministratorServlet" class="w3-bar-item w3-button w3-padding-large">Home</a>
        <a href="/LinkedInClone/AdministratorServlet/logout" class="w3-bar-item w3-button w3-padding-large">Log Out</a>
    </div>

    <!-- Page Container -->
    <div class="w3-container w3-content" style="max-width:66.%;margin-top:80px">
        <!-- The Grid -->
        <div class="w3-row">

            <!-- Middle Column -->
            <div class="w3-col">

                <table style="width: 100%">
                	
                	<tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                	<c:forEach items="${list_rows}" var="row">
        
                    <tr style="width: 100%">
                    	<c:forEach items="${row}" var="prof_con">
	                        <td style="width: 33.3%;">
	                            <div class="w3-container w3-card w3-white w3-margin">
	                                <p class="w3-center">
	                                    <a href="/LinkedInClone/AdministratorProfile?id=${prof_con.getId()}">
	                                        <img src="/LinkedInClone/ImageServlet?id=${prof_con.getPath()}" class="w3-round-large" style="height:106px;width:106px" alt="Avatar">
	                                    </a>
	                                </p>
	                                <h4 class="w3-center"><a href="/LinkedInClone/AdministratorProfile?id=${prof_con.getId()}" class="w3-link">${prof_con.getSurname()} ${prof_con.getName()}</a></h4>
	                                <hr>
	                                <p>
	                                    <i class="fa fa-envelope-open"></i> Email: ${prof_con.getEmail()}</p>
	                                <p>
	                                    <i class="fa fa-phone"></i> Phone: ${prof_con.getTelephone()}</p>
	                            </div>
	                       	</td>
                       	</c:forEach>
                    </tr>
                    </c:forEach>
                    
                </table>

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

        function check_search() {
            if (document.getElementById('search').value == "") {
                ;
            }
            else {
                location.href = "/LinkedInClone/UserNetwork";
            }
        }
    </script>
</body>

</html>