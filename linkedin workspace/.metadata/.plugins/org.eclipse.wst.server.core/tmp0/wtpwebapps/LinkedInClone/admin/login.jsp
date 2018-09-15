<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
<title>WorkConnect - Log In</title>
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

    <!-- Page Container -->
    <div class="w3-container w3-content" style="max-width:1400px;margin-top:160px">
        <!-- The Grid -->
        <div class="w3-row">

            <div class="w3-col m4">
                <p></p>
            </div>

            <!-- Middle Column -->
            <div class="w3-col m4">
                <div class="w3-card w3-white">
                    <div class="w3-container w3-padding">
                    <form action="/LinkedInClone/AdministratorServlet" method="post">
                        <table style="width:100%">
                            <tr>
                                <div class="w3-row w3-padding" style="width:100%;">
                                    <h2>WorkConnect</h2>
                                    <h5>Login as Admin</h5>
                                </div>
                            </tr>
                            <tr>
                                <div class="w3-row w3-padding" style="width:100%;">
                                    <input id="email" name="email" type="email" placeholder="Email" onkeyup="check_form(this.id);" class="w3-border w3-padding" style="width:100%;"
                                        required/>
                                </div>
                            </tr>
                            <tr>
                                <div class="w3-row w3-padding" style="width:100%;">
                                    <input id="password" name="password" type="password" placeholder="Password" onkeyup="check_form(this.id);" class="w3-border w3-padding" style="width:100%;"
                                        required/>
                                </div>
                            </tr>
                            <tr>
                                <td>
                                    <div class="w3-row w3-padding">
                                        <button id="sign_in" type="submit" onclick="check_login();" class="w3-button w3-theme-d2">
                                            <i class="fa fa-sign-in"></i> Log In</button>
                                    </div>
                                </td>
                                <td>
                                    <input id="error_message" class="w3-opacity-min" type="text" value="<%=request.getAttribute("error_message")%>" style="border: 0;background-color: inherit; color:red;font-weight: bold"
                                        readonly>
                                </td>
                            </tr>
                            <tr style="width: 200%">
                                <td style="width: 200%">
                                    <div class="w3-row w3-padding" style="width: 200%">
                                        Not an Administrator?
                                        <a href="/LinkedInClone/UserServlet">Go back to the Login page.</a>
                                    </div>
                                </td>
                            </tr>
                        </table>
                        </form>
                    </div>
                </div>

                <!-- End Middle Column -->
            </div>

        </div>
        <!-- End Grid -->
    </div>
    <!-- End Page Container -->
    <br>
    <!-- Footer -->
    <footer class="w3-container w3-theme-d5 w3-bottom">
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

        function check_form(id) {
            document.getElementById(id).setCustomValidity("");
            if (document.getElementById(id).checkValidity() == false) {
                document.getElementById(id).setCustomValidity("Invalid field.");
                if (id == "email") {
                    document.getElementById('error_message').value = "Invalid email.";
                }
                else {
                    document.getElementById('error_message').value = "Missing required fields.";
                }
            }
            else {
                document.getElementById(id).setCustomValidity("");
                document.getElementById('error_message').value = "";
            }
        }

        function check_login() {
            var error = false;
            if (document.getElementById('email').value == "") {
                document.getElementById('email').setCustomValidity("Invalid field.");
                document.getElementById('error_message').value = "Missing required fields.";
                error = true;
            }
            else if (document.getElementById('email').checkValidity() == false) {
                document.getElementById('email').setCustomValidity("Invalid field.");
                document.getElementById('error_message').value = "Invalid email.";
                error = true;
            }
            else {
                document.getElementById('email').setCustomValidity("");
            }
            if (document.getElementById('password').value == "") {
                document.getElementById('password').setCustomValidity("Invalid field.");
                document.getElementById('error_message').value = "Missing required fields.";
                error = true;
            }
            else {
                document.getElementById('password').setCustomValidity("");
            }
            if (error == false) {
                document.getElementById('error_message').value = "";
                location.href = "admin.html";
            }
        }
    </script>
</body>

</html>