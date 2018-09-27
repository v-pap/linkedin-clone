<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <form action="/LinkedInClone/UserServlet/post" method="post" enctype='multipart/form-data'>
                                <div class="w3-padding-8">
                                    <input name="post_text" id="post" type="text" placeholder="Status: Feeling great!" class="w3-border w3-padding"
                                        style="width:100%;" />
                                </div>
                                <table>
                                    <td>
                                        <button type="submit" onclick="check_post();" class="w3-button w3-theme-d2">
                                            <i class="fa fa-pencil"></i> Post</button>
                                    </td>
                                    <td>
                                        <button type="button" onclick="image_upload();" class="w3-button w3-theme-d2">
                                            <i class="fa fa-photo "></i> Photo</button>
                                        <input name="image" id='image_button' type='file' onchange="image_pick();" accept="image/jpeg"
                                            hidden />
                                    </td>
                                    <td>
                                        <button type="button" onclick="video_upload();" class="w3-button w3-theme-d2">
                                            <i class="fa fa-video-camera "></i> Video</button>
                                        <input name="video" id='video_button' type='file' onchange="video_pick();" accept="video/*"
                                            hidden />
                                    </td>
                                    <td>
                                        <button type="button" onclick="audio_upload();" class="w3-button w3-theme-d2">
                                            <i class="fa fa-music "></i> Audio</button>
                                        <input name="audio" id='audio_button' type='file' onchange="audio_pick();" accept="audio/*"
                                            hidden />
                                    </td>
                                    <td id="img_picked" class="w3-opacity">
                                    </td>
                                </table>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
				<c:forEach items="${posts_list}" var="post">
                <div class="w3-container w3-card w3-white w3-margin">
                    <br>
                    <a href="/LinkedInClone/ViewProfileServlet?id=${post.getProfessional().getId()}">
                        <img src="/LinkedInClone/ImageServlet?id=${post.getProfessional().getPath()}" alt="Avatar" class="w3-left w3-round-large w3-margin-right" style="width:60px">
                    </a>
                    <h4><a href="/LinkedInClone/ViewProfileServlet?id=${post.getProfessional().getId()}" class="w3-link">${post.getProfessional().getName()} ${post.getProfessional().getSurname()}
                    <c:if test = "${prof.getId() == post.getProfessional().getId()}">
                    <b>(Me)</b>
                    </c:if>
                    </a>
                    <c:if test = "${prof.Connected(post.getProfessional().getId())}">
                    <i class="fa fa-handshake-o" title="Connected"></i> 
                    </c:if></h4>
                    <br>
                    <hr class="w3-clear">
                    <p>${post.getText()}</p>
                    
                    <c:if test = "${!post.getPathPic().trim().isEmpty()}">
                    <img src="/LinkedInClone/ImageServlet?id=${post.getPathPic()}" style="width:100%" alt="Northern Lights" class="w3-margin-bottom">
                    </c:if>
                    <c:if test = "${!post.getPathVid().trim().isEmpty()}">
                    <video style="width: 100%" controls>
                        <source src="/multimedia/${post.getPathVid()}" type="video/mp4">
                        Your browser does not support the video tag.
                    </video>
                    </c:if>
                    <c:if test = "${!post.getPathSound().trim().isEmpty()}">
                    <audio style="width: 100%" controls>
                        <source src="/multimedia/${post.getPathSound()}" type="audio/mpeg">
                        Your browser does not support the audio tag.
                    </audio>
                    </c:if>
                    <c:choose>
                    <c:when test = "${prof.alreadyLiked(post.getPostId()) == false}">
                    <form action="/LinkedInClone/UserServlet/like" method="post">
                    <button type="submit" class="w3-button w3-theme-d2">
                        <i class="fa fa-thumbs-up"></i> Like</button>
                        <input type="hidden" name="post_id" value="${post.getPostId()}">
                    </form>
                    </c:when>
                    <c:otherwise>
                    <button type="button" disabled="true" class="w3-button w3-theme-d2">
                        <i class="fa fa-thumbs-up"></i> Liked</button>
                    </c:otherwise>
                    </c:choose>
                    <hr class="w3-clear">
                    <table style="width:100%">
                    	<c:forEach items="${post.getComments()}" var="comment">
                        <tr>
                            <td>
                                <a href="/LinkedInClone/ViewProfileServlet?id=${comment.getProfessional().getId()}">
                                    <img src="/LinkedInClone/ImageServlet?id=${comment.getProfessional().getPath()}" alt="Avatar" class="w3-left w3-round-large w3-margin-right w3-margin-bottom"
                                        style="width:60px">
                                </a>
                            </td>
                            <td style="width: 100%">
                                <p>${comment.getText()}</p>
                            </td>
                        </tr>
                        </c:forEach>
                    </table>
                    <form action="/LinkedInClone/UserServlet/comment" method="post">
                    <table style="width:100%">
                        <td style="width: 100%">
                            <input name="comment" type="text" placeholder="Leave a comment" class="w3-border w3-padding w3-margin-bottom"
                                style="width:100%;" />
                             <input type="hidden" name="post_id" value="${post.getPostId()}">
                        </td>
                        <td style="width: 100%">
                            <button type="submit" class="w3-button w3-theme-d2 w3-margin-bottom">
                                <i class="fa fa-comment"></i> Comment</button>
                        </td>
                    </table>
                    </form>
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
            document.getElementById('image_button').click();
        }
        
        function video_upload() {
            document.getElementById('video_button').click();
        }
        
        function audio_upload() {
            document.getElementById('audio_button').click();
        }

        function image_pick() {
            var selected_file = document.getElementById('image_button').files[0];
            document.getElementById('img_picked').innerHTML = "Selected file: " + selected_file.name;
        }
        
        function video_pick() {
            var selected_file = document.getElementById('video_button').files[0];
            document.getElementById('img_picked').innerHTML = "Selected file: " + selected_file.name;
        }
        
        function audio_pick() {
            var selected_file = document.getElementById('audio_button').files[0];
            document.getElementById('img_picked').innerHTML = "Selected file: " + selected_file.name;
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