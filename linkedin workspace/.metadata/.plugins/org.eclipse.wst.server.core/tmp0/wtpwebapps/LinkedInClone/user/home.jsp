<!DOCTYPE html>
<html>
<title>WorkConnect - Home</title>
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
                <div class="w3-row-padding">
                    <div class="w3-col m12">
                        <div class="w3-card w3-white">
                            <div class="w3-container w3-padding">
                                <div class="w3-padding-8">
                                    <input id="post" type="text" placeholder="Status: Feeling great!" class="w3-border w3-padding" style="width:100%;" />
                                </div>
                                <table>
                                    <td>
                                        <button type="button" onclick="check_post();" class="w3-button w3-theme-d2">
                                            <i class="fa fa-pencil"></i> Post</button>
                                    </td>
                                    <td>
                                        <button type="button" onclick="image_upload();" class="w3-button w3-theme-d2">
                                            <i class="fa fa-photo "></i> Photo</button>
                                        <input id='upload_button' type='file' onchange="image_pick();" hidden/>
                                    </td>
                                    <td id="img_picked" class="w3-opacity">
                                    </td>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="w3-container w3-card w3-white w3-margin">
                    <br>
                    <a href="user_profile.html">
                        <img src="${pageContext.request.contextPath}/images/avatar2.png" alt="Avatar" class="w3-left w3-round-large w3-margin-right" style="width:60px">
                    </a>
                    <h4><a href="user_profile.html" class="w3-link">John Doe</a></h4>
                    <br>
                    <hr class="w3-clear">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                        aliquip ex ea commodo consequat.
                    </p>
                    <img src="${pageContext.request.contextPath}/images/lights.jpg" style="width:100%" alt="Northern Lights" class="w3-margin-bottom">
                    <button type="button" class="w3-button w3-theme-d2">
                        <i class="fa fa-thumbs-up"></i> Like</button>
                    <hr class="w3-clear">
                    <table style="width:100%">
                        <tr>
                            <td>
                                <a href="user_profile.html">
                                    <img src="${pageContext.request.contextPath}/images/avatar2.png" alt="Avatar" class="w3-left w3-round-large w3-margin-right w3-margin-bottom" style="width:60px">
                                </a>
                            </td>
                            <td style="width: 100%">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt
                                    ut labore et dolore magna aliqua.</p>
                            </td>
                        </tr>
                    </table>
                    <table style="width:100%">
                        <td style="width: 100%">
                            <input type="text" placeholder="Leave a comment" class="w3-border w3-padding w3-margin-bottom" style="width:100%;" />
                        </td>
                        <td style="width: 100%">
                            <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom">
                                <i class="fa fa-comment"></i> Comment</button>
                        </td>
                    </table>
                </div>

                <div class="w3-container w3-card w3-white w3-margin">
                    <br>
                    <a href="user_profile.html">
                        <img src="${pageContext.request.contextPath}/images/avatar5.png" alt="Avatar" class="w3-left w3-round-large w3-margin-right" style="width:60px">
                    </a>
                    <h4><a href="user_profile.html" class="w3-link">Jane Doe</a></h4>
                    <br>
                    <hr class="w3-clear">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                        aliquip ex ea commodo consequat.
                    </p>
                    <button type="button" class="w3-button w3-theme-d2">
                        <i class="fa fa-thumbs-up"></i> Like</button>
                    <hr class="w3-clear">
                    <table style="width:100%">
                        <tr>
                        </tr>
                    </table>
                    <table style="width:100%">
                        <td style="width: 100%">
                            <input type="text" placeholder="Leave a comment" class="w3-border w3-padding w3-margin-bottom" style="width:100%;" />
                        </td>
                        <td style="width: 100%">
                            <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom">
                                <i class="fa fa-comment"></i> Comment</button>
                        </td>
                    </table>
                </div>

                <div class="w3-container w3-card w3-white w3-margin">
                    <br>
                    <a href="user_profile.html">
                        <img src="${pageContext.request.contextPath}/images/avatar6.png" alt="Avatar" class="w3-left w3-round-large w3-margin-right" style="width:60px">
                    </a>
                    <h4><a href="user_profile.html" class="w3-link">Angie Jane</a></h4>
                    <br>
                    <hr class="w3-clear">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore
                        et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
                        aliquip ex ea commodo consequat.
                    </p>
                    <img src="${pageContext.request.contextPath}/images/nature.jpg" style="width:100%" class="w3-margin-bottom">
                    <button type="button" class="w3-button w3-theme-d2">
                        <i class="fa fa-thumbs-up"></i> Like</button>
                    <hr class="w3-clear">
                    <table style="width:100%">
                        <tr>
                            <td>
                                <a href="user_profile.html">
                                    <img src="${pageContext.request.contextPath}/images/avatar2.png" alt="Avatar" class="w3-left w3-round-large w3-margin-right w3-margin-bottom" style="width:60px">
                                </a>
                            </td>
                            <td style="width: 100%">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt
                                    ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation
                                    ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                            </td>
                        </tr>
                    </table>
                    <table style="width:100%">
                        <td style="width: 100%">
                            <input type="text" placeholder="Leave a comment" class="w3-border w3-padding w3-margin-bottom" style="width:100%;" />
                        </td>
                        <td style="width: 100%">
                            <button type="button" class="w3-button w3-theme-d2 w3-margin-bottom">
                                <i class="fa fa-comment"></i> Comment</button>
                        </td>
                    </table>
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

        function check_post() {
            if (document.getElementById('post').value == "") {
                ;
            }
            else {
                ;
            }
        }
    </script>
</body>

</html>