<!DOCTYPE html>
<html>
<title>WorkConnect - Register</title>
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

<body background="images/welcome.jpg" class="w3-theme-l5">

    <!-- Page Container -->
    <div class="w3-container w3-content" style="max-width:1400px;margin-top:160px">
        <!-- The Grid -->
        <div class="w3-row">

            <!-- Left Column -->
            <div class="w3-col m8">
                <h1 style=font-size:50px class="w3-outline">WorkConnect</h1>
                <br>
                <h3 class="w3-outline">Manage your professional identity.</h3>
                <h3 class="w3-outline">Build and engage with your professional network.</h3>
                <h3 class="w3-outline">Access knowledge, insights and opportunities.</h3>
            </div>
            <!-- End Left Column -->

            <!-- Middle Column -->
            <div class="w3-col m4">
                <div class="w3-card w3-white">
                    <div class="w3-container w3-padding">
                        <form action="/LinkedInClone/RegisterServlet" method="post" enctype='multipart/form-data'>
                            <table style="width:100%">
                                <tr>
                                    <div class="w3-row w3-padding" style="width:100%;">
                                        <a href="/LinkedInClone/UserServlet">
                                            <i class="fa fa-arrow-left"></i>
                                            Return
                                        </a>
                                    </div>
                                </tr>
                                <tr>
                                    <div class="w3-row w3-padding" style="width:100%;">
                                        <input id="name" name="name" type="text" placeholder="Name" onkeyup="check_form(this.id);"
                                            class="w3-border w3-padding" style="width:100%;" required />
                                    </div>
                                </tr>
                                <tr>
                                    <div class="w3-row w3-padding" style="width:100%;">
                                        <input id="surname" name="surname" type="text" placeholder="Surname" onkeyup="check_form(this.id);"
                                            class="w3-border w3-padding" style="width:100%;" required />
                                    </div>
                                </tr>
                                <tr>
                                    <div class="w3-row w3-padding" style="width:100%;">
                                        <input id="email" name="email" type="email" placeholder="Email" onkeyup="check_form(this.id);"
                                            class="w3-border w3-padding" style="width:100%;" required />
                                    </div>
                                </tr>
                                <tr>
                                    <div class="w3-row w3-padding" style="width:100%;">
                                        <input id="phone" name="telephone" type="text" placeholder="Phone Number"
                                            onkeyup="check_form(this.id);" class="w3-border w3-padding" style="width:100%;"
                                            required />
                                    </div>
                                </tr>
                                <tr>
                                    <div class="w3-row w3-padding" style="width:100%;">
                                        <input id="job_title" name="job_title" type="text" placeholder="Job Title"
                                            onkeyup="check_form(this.id);" class="w3-border w3-padding" style="width:100%;"
                                            required />
                                    </div>
                                </tr>
                                <tr>
                                    <div class="w3-row w3-padding" style="width:100%;">
                                        <input id="password" name="password" type="password" placeholder="Password"
                                            onkeyup="check_form(this.id);comparePasswords();" class="w3-border w3-padding"
                                            style="width:100%;" required />
                                    </div>
                                </tr>
                                <tr>
                                    <div class="w3-row w3-padding" style="width:100%;">
                                        <input id="c_password" name="c_password" type="password" placeholder="Confirm Password"
                                            onkeyup="check_form(this.id);comparePasswords();" class="w3-border w3-padding"
                                            style="width:100%;" required />
                                    </div>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="w3-row w3-padding" style="width:100%;">
                                            <img id="profile_img" name="profile_img" src='images/placeholder.png' alt='Image not found. Please try again.'
                                                width="160" height="160" class='w3-border'>
                                        </div>
                                    </td>
                                    <td>
                                        <div class="w3-row w3-padding" style="width:100%;">
                                            <table>
                                                <tr>
                                                    <p>Select and upload a profile image.</p>
                                                </tr>
                                                <tr>
                                                    <button type="button" onclick="image_upload();" class="w3-button w3-theme-d2">
                                                        <i class="fa fa-upload "></i> Browse</button>
                                                    <input id='upload_button' type='file' name="image" onchange="image_preview();"
                                                        hidden />
                                                </tr>
                                            </table>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="w3-row w3-padding ">
                                            <button id="register" type="submit" onclick="check_register();" class="w3-button w3-theme-d2 ">
                                                <i class="fa fa-sign-in "></i> Register</button>
                                        </div>
                                    </td>
                                    <td>
                                        <input id="error_message" class="w3-opacity-min" type="text" value="<%=request.getAttribute("error_message")%>" style="border: 0;background-color: inherit;
                                        color:red;font-weight: bold"
                                        readonly>
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
            var x = document.getElementById("navDemo ");
            if (x.className.indexOf("w3-show ") == -1) {
                x.className += " w3-show ";
            } else {
                x.className = x.className.replace(" w3-show ", " ");
            }
        }

        function image_upload() {
            document.getElementById('upload_button').click();
        }


        function image_preview() {
            var selected_image = document.getElementById('upload_button').files[0];
            document.getElementById('profile_img').src = window.URL.createObjectURL(selected_image);
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

        function comparePasswords() {
            if ((document.getElementById('password').value != "" &&
                document.getElementById('password').value != "") &&
                (document.getElementById('password').value ==
                    document.getElementById('c_password').value)) {
                document.getElementById('password').setCustomValidity("");
                document.getElementById('c_password').setCustomValidity("");
                return true;
            } else {
                document.getElementById('password').setCustomValidity("Invalid field.");
                document.getElementById('c_password').setCustomValidity("Invalid field.");
                document.getElementById('error_message').value = "Passwords not matching.";
                return false;
            }
        }

        function check_register() {
            var error = false, id_arr = ["name", "surname", "email", "phone", "password", "c_password"];
            if (document.getElementById('email').checkValidity() == false) {
                document.getElementById('email').setCustomValidity("Invalid field.");
                document.getElementById('error_message').value = "Invalid email.";
                error = true;
            }
            else {
                document.getElementById('email').setCustomValidity("");
            }
            for (var i = 0; i < id_arr.length; i++) {
                if (document.getElementById(id_arr[i]).value == "") {
                    document.getElementById(id_arr[i]).setCustomValidity("Invalid field.");
                    document.getElementById('error_message').value = "Missing required fields.";
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
                document.getElementById('error_message').value = "";
                location.href = "home.html";
            }
        }
    </script>
</body>

</html>