<!DOCTYPE html>
<html>
<title>WorkConnect - Settings</title>
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
            <a href="notifications.html" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-bell"></i>
                Notifications
            </a>
            <a href="messages.html" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-envelope"></i>
                Messages
            </a>
            <a href="jobs.html" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
                <i class="fa fa-list"></i>
                Jobs
            </a>
            <a href="network.html" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large">
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
        <a href="network.html" class="w3-bar-item w3-button w3-padding-large">Network</a>
        <a href="jobs.html" class="w3-bar-item w3-button w3-padding-large">Jobs</a>
        <a href="messages.html" class="w3-bar-item w3-button w3-padding-large">Messages</a>
        <a href="notifications.html" class="w3-bar-item w3-button w3-padding-large">Notifications</a>
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
				<form action="/LinkedInClone/UserSettings/email" method="post">
                <div class="w3-container w3-card w3-white w3-margin">
                    <div class="w3-row w3-padding" style="width:100%;">
                        <h4>Email</h4>
                    </div>
                    <div class="w3-row w3-padding" style="width:100%;">
                        <input id="e_email" name="e_email" type="email" placeholder="New Email" onkeyup="check_e_form(this.id);" class="w3-border w3-padding" style="width:100%;"
                            required/>
                    </div>
                    <div class="w3-row w3-padding" style="width:100%;">
                        <input id="e_password" name="e_password" type="password" placeholder="Confirm Password" onkeyup="check_e_form(this.id);" class="w3-border w3-padding"
                            style="width:100%;" required/>
                    </div>
                    <table>
                        <td>
                            <div class="w3-row w3-padding" style="width:100%;">
                                <button type="submit" onclick="check_e_change();" class="w3-button w3-theme-d2 w3-margin-bottom">
                                    <i class="fa fa-edit"></i> Change</button>
                        </td>
                        <td>
                            <input id="e_error_message" class="w3-opacity-min" type="text" value="<%=request.getAttribute("e_error_message")%>" style="border: 0;background-color: inherit; color:<%=request.getAttribute("e_color")%>;font-weight: bold"
                                readonly>
                        </td>
                        </div>

                    </table>
                </div>
                </form>
                <form action="/LinkedInClone/UserSettings/password" method="post">
                <div class="w3-container w3-card w3-white w3-margin">
                    <div class="w3-row w3-padding" style="width:100%;">
                        <h4>Password</h4>
                    </div>
                    <div class="w3-row w3-padding" style="width:100%;">
                        <input id="p_password" name="p_password" type="password" placeholder="New Password" onkeyup="check_p_form(this.id);comparePasswords();" class="w3-border w3-padding"
                            style="width:100%;" required/>
                    </div>
                    <div class="w3-row w3-padding" style="width:100%;">
                        <input id="p_new_password" name="p_new_password" type="password" placeholder="Confirm New Password" onkeyup="check_p_form(this.id);comparePasswords();"
                            class="w3-border w3-padding" style="width:100%;" required/>
                    </div>
                    <div class="w3-row w3-padding" style="width:100%;">
                        <input id="p_c_password" name="p_c_password" type="password" placeholder="Confirm Current Password" onkeyup="check_p_form(this.id);"
                            class="w3-border w3-padding" style="width:100%;" required/>
                    </div>
                    <table>
                        <td>
                            <div class="w3-row w3-padding" style="width:100%;">
                                <button type="submit" onclick="check_p_change();" class="w3-button w3-theme-d2 w3-margin-bottom">
                                    <i class="fa fa-edit"></i> Change</button>
                            </div>
                        </td>
                        <td>
                            <input id="p_error_message" class="w3-opacity-min" type="text" value="<%=request.getAttribute("p_error_message")%>" style="border: 0;background-color: inherit; color:<%=request.getAttribute("p_color")%>;font-weight: bold"
                                readonly>
                        </td>
                    </table>
                </div>
            	</form>
            </div>

        </div>
        <!-- End Grid -->
    </div>
    <!-- End Page Container -->
    </div>
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

        function check_p_form(id) {
            document.getElementById(id).setCustomValidity("");
            if (document.getElementById(id).checkValidity() == false) {
                document.getElementById(id).setCustomValidity("Invalid field.");
                document.getElementById('p_error_message').value = "Missing required fields.";
            }
            else {
                document.getElementById(id).setCustomValidity("");
                document.getElementById('p_error_message').value = "";
            }
        }

        function check_e_form(id) {
            document.getElementById(id).setCustomValidity("");
            if (document.getElementById(id).checkValidity() == false) {
                document.getElementById(id).setCustomValidity("Invalid field.");
                if (id == "e_email") {
                    document.getElementById('e_error_message').value = "Invalid email.";
                }
                else {
                    document.getElementById('e_error_message').value = "Missing required fields.";
                }
            }
            else {
                document.getElementById(id).setCustomValidity("");
                document.getElementById('e_error_message').value = "";
            }
        }

        function comparePasswords() {
            if ((document.getElementById('p_password').value != "" &&
                document.getElementById('p_new_password').value != "") &&
                (document.getElementById('p_password').value ==
                    document.getElementById('p_new_password').value)) {
                document.getElementById('p_password').setCustomValidity("");
                document.getElementById('p_new_password').setCustomValidity("");
                return true;
            } else {
                document.getElementById('p_password').setCustomValidity("Invalid field.");
                document.getElementById('p_new_password').setCustomValidity("Invalid field.");
                document.getElementById('p_error_message').value = "Passwords not matching.";
                return false;
            }
        }

        function check_e_change() {
            var error = false;
            if (document.getElementById('e_email').value == "") {
                document.getElementById('e_email').setCustomValidity("Invalid field.");
                document.getElementById('e_error_message').value = "Missing required fields.";
                error = true;
            }
            else {
                document.getElementById('e_mail').setCustomValidity("");
            }
            if (document.getElementById('e_password').value == "") {
                document.getElementById('e_password').setCustomValidity("Invalid field.");
                document.getElementById('e_error_message').value = "Missing required fields.";
                error = true;
            }
            else {
                document.getElementById().setCustomValidity("");
            }
            if (error == false) {
                document.getElementById('e_error_message').value = "";
            }
        }

        function check_p_change() {
            var error = false, id_arr = ["p_password", "p_new_password", "p_c_password"];
            for (var i = 0; i < id_arr.length; i++) {
                if (document.getElementById(id_arr[i]).value == "") {
                    document.getElementById(id_arr[i]).setCustomValidity("Invalid field.");
                    document.getElementById('p_error_message').value = "Missing required fields.";
                    error = true;
                }
                else {
                    document.getElementById(id_arr[i]).setCustomValidity("");
                }
            }
            if (comparePasswords() == false) {
                error = true;
            }
            if (error == false) {
                document.getElementById('p_error_message').value = "";
            }
        }
    </script>
</body>

</html>