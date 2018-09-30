<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
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
        <form action="/LinkedInClone/UserProfile" method="post" enctype='multipart/form-data'>

            <!-- Middle Column -->
            <div class="w3-col m4">

                <div class="w3-container w3-card w3-white w3-margin">
                    <br>
                    <img name="profile_img" id="profile_img" src="/LinkedInClone/ImageServlet?id=${prof.getPath()}" alt="Avatar" style="width:100%" class="w3-round-large w3-margin-bottom">
                    <table>
                        <td>
                            <p class="w3-opacity-min">Select and upload a new profile image.</p>
                        </td>
                        <td>
                            <button type="button" onclick="image_upload();" class="w3-button w3-theme-d2">
                                <i class="fa fa-upload "></i> Browse</button>
                            <input id='upload_button' type='file' name="image" onchange="image_preview();" hidden />
                        </td>
                    </table>
                    <hr class="w3-clear">
                    <div class="w3-row w3-padding-8" style="width:100%;">
                        <input id="name" name="name" type="text" placeholder="Name" value="${prof.getName()}" class="w3-border w3-padding" style="width:100%;" />
                    </div>
                    <div class="w3-row w3-padding-8" style="width:100%;">
                        <input id="surname" name="surname" type="text" placeholder="Surname" value="${prof.getSurname()}" class="w3-border w3-padding" style="width:100%;" />
                    </div>
                    <hr class="w3-clear">
                    <div class="w3-row w3-padding-8" style="width:100%;">
                        <input id="description" name="description" type="text" placeholder="Description" value="${prof.getJobTitle()}" class="w3-border w3-padding" style="width:100%;" />
                    </div>
                    <hr class="w3-clear">
                    <h4>Contact Info</h4>
                    <div class="w3-row w3-padding-8" style="width:100%;">
                        <input name="telephone" type="text" placeholder="Phone" value="${prof.getTelephone()}" class="w3-border w3-padding" style="width:100%;" />
                    </div>
                </div>

                <!-- End Middle Column -->
            </div>

            <div class="w3-col m8">
                <div class="w3-container w3-card w3-white w3-margin">
                    <table style="width:100%;">
                        <td>
                            <h4>Work Experience</h4>
                        </td>
                        <td>
                            <div style="float:right;">
                                <input type="radio" name="w_visibility" value="Public" style="vertical-align: sub"
                                    ${prof.getExperiencePrivate()=='false'?'checked':''}> Public
                                <input type="radio" name="w_visibility" value="Private" style="vertical-align: sub"
                                ${prof.getExperiencePrivate()=='true'?'checked':''}>
                                Private
                            </div>
                        </td>
                    </table>
                    <div name="work_wrapper" id="work_wrapper">
                    <c:forEach items="${prof.getExperiences()}" var="experience" varStatus="loop">
                        <div name="work_title_wrapper_${loop.count}" id="work_title_wrapper_${loop.count}" class="w3-row w3-padding-8" style="width:100%;">
                            <input name="work_title_${loop.count}" id="work_title_${loop.count}" type="text" placeholder="Title" class="w3-border w3-padding"
                                style="width:40%" value="${experience.getTitle()}"/>
                            <input name="work_from_${loop.count}" id="work_from_${loop.count}" placeholder="From" type="text" class="w3-border w3-padding"
                                style="width: 29%" onfocus="(this.type='date')" onblur="(this.type='text')" value="${experience.getFrom()}">
                            <input name="work_to_${loop.count}" id="work_to_${loop.count}" placeholder="To" type="text" class="w3-border w3-padding"
                                style="width: 29%" onfocus="(this.type='date')" onblur="(this.type='text')" value="${experience.getTo()}">
                        </div>
                        <div name="work_description_wrapper_${loop.count}" id="work_description_wrapper_${loop.count}" class="w3-row w3-padding-8"
                            style="width:100%;">
                            <input name ="work_description_${loop.count}" id="work_description_${loop.count}" type="text" placeholder="Description" class="w3-border w3-padding"
                                style="width:100%;" value="${experience.getDescription()}"/>
                        </div>
                        <div name="work_remove_wrapper_${loop.count}" id='work_remove_wrapper_${loop.count}' class="w3-row w3-padding-8" style="width:100%;">
                            <button name="work_remove_${loop.count}" id="work_remove_${loop.count}" type="button" onclick="remove_work(this.id);"
                                class="w3-button w3-theme-d2">
                                <i class="fa fa-minus"></i> Remove Entry</button>
                        </div>
                    </c:forEach>
                    </div>
                    <input type="hidden" id="return_experience" name="return_experience"/>
                    <%int numOfExperience = (Integer) request.getAttribute("num_of_experience");%>
                    <div class="w3-row w3-padding-8" style="width:100%;">
                        <button type="button" onclick="add_work();" class="w3-button w3-theme-d2 w3-margin-bottom">
                            <i class="fa fa-plus"></i> Add Entry</button>
                    </div>
                    <hr class="w3-clear">
                    <table style="width:100%;">
                        <td>
                            <h4>Education</h4>
                        </td>
                        <td>
                            <fdiv style="float:right;">
                                <input type="radio" name="e_visibility" value="Public" style="vertical-align: sub"
                                    ${prof.getEducationPrivate()=='false'?'checked':''}> Public
                                <input type="radio" name="e_visibility" value="Private" style="vertical-align: sub"
                                ${prof.getEducationPrivate()=='true'?'checked':''}>
                                Private
                            </div>
                        </td>
                    </table>
                    <div name="education_wrapper" id="education_wrapper">
                    <c:forEach items="${prof.getEducations()}" var="education" varStatus="loop">
                        <div name="education_title_wrapper_${loop.count}" id="education_title_wrapper_${loop.count}" class="w3-row w3-padding-8" style="width:100%;">
                            <input name="education_title_${loop.count}" id="education_title_${loop.count}" type="text" placeholder="Title" class="w3-border w3-padding"
                                style="width:40%" value="${education.getTitle()}"/>
                            <input name="education_from_${loop.count}" id="education_from_${loop.count}" placeholder="From" type="text" class="w3-border w3-padding"
                                style="width: 29%" onfocus="(this.type='date')" onblur="(this.type='text')" value="${education.getFrom()}">
                            <input name="education_to_${loop.count}" id="education_to_${loop.count}" placeholder="To" type="text" class="w3-border w3-padding"
                                style="width: 29%" onfocus="(this.type='date')" onblur="(this.type='text')" value="${education.getTo()}">
                        </div>
                        <div name="education_description_wrapper_${loop.count}" id="education_description_wrapper_${loop.count}" class="w3-row w3-padding-8"
                            style="width:100%;">
                            <input name ="education_description_${loop.count}" id="education_description_${loop.count}" type="text" placeholder="Description" class="w3-border w3-padding"
                                style="width:100%;" value="${education.getDescription()}"/>
                        </div>
                        <div name="education_remove_wrapper_${loop.count}" id='education_remove_wrapper_${loop.count}' class="w3-row w3-padding-8" style="width:100%;">
                            <button name="education_remove_${loop.count}" id="education_remove_${loop.count}" type="button" onclick="remove_education(this.id);"
                                class="w3-button w3-theme-d2">
                                <i class="fa fa-minus"></i> Remove Entry</button>
                        </div>
                    </c:forEach>
                    </div>
                    <input type="hidden" id="return_education" name="return_education"/>
                    <%int numOfEducation = (Integer) request.getAttribute("num_of_education");%>
                    <div class="w3-row w3-padding-8" style="width:100%;">
                        <button type="button" onclick="add_education();" class="w3-button w3-theme-d2 w3-margin-bottom">
                            <i class="fa fa-plus"></i> Add Entry</button>
                    </div>
                    <hr class="w3-clear">
                    <table style="width:100%;">
                        <td>
                            <h4>Skills</h4>
                        </td>
                        <td>
                            <div style="float:right;">
                                <input type="radio" name="s_visibility" value="Public" style="vertical-align: sub"
                                    ${prof.getSkillsPrivate()=='false'?'checked':''}> Public
                                <input type="radio" name="s_visibility" value="Private" style="vertical-align: sub"
                                ${prof.getSkillsPrivate()=='true'?'checked':''}>
                                Private
                            </div>
                        </td>
                    </table>
                    <div class="w3-row w3-padding-8" style="width:100%;">
                        <input name = "skills" type="text" placeholder="Interests. Use a comma (,) to separate your different skills."
                            class="w3-border w3-padding" style="width:100%;" value="<%=request.getAttribute("skill_commas")%>"/>
                    </div>
                    <div class="w3-row w3-padding-8" style="width:100%;">
                        <button type="button" onclick="location.href='/LinkedInClone/UserProfile'" class="w3-button w3-theme-d2 w3-margin-bottom">
                            <i class="fa fa-arrow-left"></i> Cancel</button>
                        <button type="submit" onclick="check_input();" class="w3-button w3-theme-d2 w3-margin-bottom">
                            <i class="fa fa-save"></i> Save</button>
                        <input id="error_message" class="w3-opacity-min" type="text" value="" style="border: 0;background-color: inherit; color:red;font-weight: bold"
                            readonly>
                    </div>
                </div>
                

                <!-- End Middle Column -->
            </div>
		</form>
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


        function image_preview() {
            var selected_image = document.getElementById('upload_button').files[0];
            document.getElementById('profile_img').src = window.URL.createObjectURL(selected_image);
        }

        var education_counter = <%=numOfEducation%>, work_counter = <%=numOfExperience%>;
        function add_work() {
            var work_title_list = [], work_from_list = [], work_description_list = [];
            for (var i = 1; i <= work_counter; i++) {
                var work_title = 'work_title_%num%'.replace('%num%', i),
                    work_from = 'work_from_%num%'.replace('%num%', i),
                    work_description = 'work_description_%num%'.replace('%num%', i);

                if (document.getElementById(work_title)) {
                    work_title_list.push(document.getElementById(work_title).value);
                    work_from_list.push(document.getElementById(work_from).value);
                    work_description_list.push(document.getElementById(work_description).value);
                }
                else {
                    work_title_list.push('');
                    work_from_list.push('');
                    work_description_list.push('');
                }
            }

            work_counter += 1;
            var field_to_add = '<div name="work_title_wrapper_%num%" id="work_title_wrapper_%num%" class="w3-row" style="width:100%;">\n<hr class="w3-clear">\n<input name="work_title_%num%" id="work_title_%num%" type="text" placeholder="Title" class="w3-border w3-padding" style="width:40%;" />\n<input name="work_from_%num%" id="work_from_%num%" placeholder="From" type="text" class="w3-border w3-padding" style="width: 29%" onfocus="(this.type=\'date\')"onblur="(this.type=\'text\')">\n<input name="work_to_%num%" id="work_to_%num%" placeholder="To" type="text" class="w3-border w3-padding" style="width: 29%" onfocus="(this.type=\'date\')"onblur="(this.type=\'text\')">\n</div>\n<div name="work_description_wrapper_%num%" id="work_description_wrapper_%num%" class="w3-row w3-padding-8" style="width:100%;">\n<input name="work_description_%num%" id="work_description_%num%" type="text" placeholder="Description" class="w3-border w3-padding" style="width:100%;" />\n</div><div id="work_remove_wrapper_%num%" class="w3-row w3-padding-8" style="width:100%;"><button name="work_remove_%num%" id="work_remove_%num%" type="button" onclick="remove_work(this.id);" class="w3-button w3-theme-d2"><i class="fa fa-minus"></i> Remove Entry</button></div>'.replace(/%num%/g, work_counter);
            document.getElementById('work_wrapper').innerHTML += field_to_add;

            for (var i = 1; i < work_counter; i++) {
                var work_title = 'work_title_%num%'.replace('%num%', i),
                    work_from = 'work_from_%num%'.replace('%num%', i),
                    work_description = 'work_description_%num%'.replace('%num%', i);

                if (document.getElementById(work_title)) {
                    document.getElementById(work_title).value = work_title_list[i - 1];
                    document.getElementById(work_from).value = work_from_list[i - 1];
                    document.getElementById(work_description).value = work_description_list[i - 1];
                }
            }        
        }

        function remove_work(id) {
            var id_num = id.split('_').pop();
            var work_title_to_remove = "work_title_wrapper_%num%".replace("%num%", id_num),
                work_description_to_remove = "work_description_wrapper_%num%".replace("%num%", id_num),
                work_remove_wrapper = 'work_remove_wrapper_%num%'.replace("%num%", id_num);
            document.getElementById(work_title_to_remove).outerHTML = "";
            document.getElementById(work_description_to_remove).outerHTML = "";
            document.getElementById(work_remove_wrapper).outerHTML = "";
        }

        function add_education() {
            var education_title_list = [], education_from_list = [], education_description_list = [];
            for (var i = 1; i <= education_counter; i++) {
                var education_title = 'education_title_%num%'.replace('%num%', i),
                    education_from = 'education_from_%num%'.replace('%num%', i),
                    education_description = 'education_description_%num%'.replace('%num%', i);

                if (document.getElementById(education_title)) {
                    education_title_list.push(document.getElementById(education_title).value);
                    education_from_list.push(document.getElementById(education_from).value);
                    education_description_list.push(document.getElementById(education_description).value);
                }
                else {
                    education_title_list.push('');
                    education_from_list.push('');
                    education_description_list.push('');
                }
            }

            education_counter += 1;
            var field_to_add = '<div name="education_title_wrapper_%num%" id="education_title_wrapper_%num%" class="w3-row" style="width:100%;">\n<hr class="w3-clear">\n<input name="education_title_%num%" id="education_title_%num%" type="text" placeholder="Title" class="w3-border w3-padding" style="width:40.5%;" />\n<input name="education_from_%num%" id="education_from_%num%" placeholder="From" type="text" class="w3-border w3-padding" style="width: 29%" onfocus="(this.type=\'date\')"onblur="(this.type=\'text\')">\n<input name="education_to_%num%" id="education_to_%num%" placeholder="To" type="text" class="w3-border w3-padding" style="width: 29%" onfocus="(this.type=\'date\')"onblur="(this.type=\'text\')">\n</div>\n<div name="education_description_wrapper_%num%" id="education_description_wrapper_%num%" class="w3-row w3-padding-8" style="width:100%;">\n<input name="education_description_%num%" id="education_description_%num%" type="text" placeholder="Description" class="w3-border w3-padding" style="width:100%;" />\n</div><div name="education_remove_wrapper_%num%" id="education_remove_wrapper_%num%" class="w3-row w3-padding-8" style="width:100%;"><button name="education_remove_%num%" id="education_remove_%num%" type="button" onclick="remove_education(this.id);" class="w3-button w3-theme-d2"><i class="fa fa-minus"></i> Remove Entry</button></div>'.replace(/%num%/g, education_counter);
            document.getElementById('education_wrapper').innerHTML += field_to_add;

            for (var i = 1; i < education_counter; i++) {
                var education_title = 'education_title_%num%'.replace('%num%', i),
                    education_from = 'education_from_%num%'.replace('%num%', i),
                    education_description = 'education_description_%num%'.replace('%num%', i);

                if (document.getElementById(education_title)) {
                    document.getElementById(education_title).value = education_title_list[i - 1];
                    document.getElementById(education_from).value = education_from_list[i - 1];
                    document.getElementById(education_description).value = education_description_list[i - 1];
                }
            }        
        }


        function remove_education(id) {
            var id_num = id.split('_').pop();
            var education_title_to_remove = "education_title_wrapper_%num%".replace("%num%", id_num),
                education_description_to_remove = "education_description_wrapper_%num%".replace("%num%", id_num),
                education_remove_wrapper = 'education_remove_wrapper_%num%'.replace("%num%", id_num);
            document.getElementById(education_title_to_remove).outerHTML = "";
            document.getElementById(education_description_to_remove).outerHTML = "";
            document.getElementById(education_remove_wrapper).outerHTML = "";
        }
        
        function check_input() {
        	document.getElementById("return_experience").value = work_counter;
        	document.getElementById("return_education").value = education_counter;
            var error = false;
            for (var i = 1; i <= work_counter; i++) {

                var work_title = 'work_title_%num%'.replace('%num%', i),
                    work_from = 'work_from_%num%'.replace('%num%', i),
                    work_description = 'work_description_%num%'.replace('%num%', i);

                if (document.getElementById(work_title)) {
                    if (document.getElementById(work_title).value == "") {
                        document.getElementById(work_title).setCustomValidity("Invalid field.");
                        document.getElementById('error_message').value = "Missing required fields.";
                        error = true;
                    }
                    if (document.getElementById(work_from).value == "") {
                        document.getElementById(work_from).setCustomValidity("Invalid field.");
                        document.getElementById('error_message').value = "Missing required fields.";
                        error = true;
                    }
                    if (document.getElementById(work_description).value == "") {
                        document.getElementById(work_description).setCustomValidity("Invalid field.");
                        document.getElementById('error_message').value = "Missing required fields.";
                        error = true;
                    }
                }
            }
            for (var i = 1; i <= education_counter; i++) {
                var education_title = 'education_title_%num%'.replace('%num%', i),
                    education_from = 'education_from_%num%'.replace('%num%', i),
                    education_description = 'education_description_%num%'.replace('%num%', i);

                if (document.getElementById(education_title)) {
                    if (document.getElementById(education_title).value == "") {
                        document.getElementById(education_title).setCustomValidity("Invalid field.");
                        document.getElementById('error_message').value = "Missing required fields.";
                        error = true;
                    }
                    if (document.getElementById(education_from).value == "") {
                        document.getElementById(education_from).setCustomValidity("Invalid field.");
                        document.getElementById('error_message').value = "Missing required fields.";
                        error = true;
                    }
                    if (document.getElementById(education_description).value == "") {
                        document.getElementById(education_description).setCustomValidity("Invalid field.");
                        document.getElementById('error_message').value = "Missing required fields.";
                        error = true;
                    }
                }
            }
            if (document.getElementById('name').value == "") {
                document.getElementById('name').setCustomValidity("Invalid field.");
                document.getElementById('error_message').value = "Missing required fields.";
                error = true;
            }
            if (document.getElementById('surname').value == "") {
                document.getElementById('surname').setCustomValidity("Invalid field.");
                document.getElementById('error_message').value = "Missing required fields.";
                error = true;
            }
            if (document.getElementById('description').value == "") {
                document.getElementById('description').setCustomValidity("Invalid field.");
                document.getElementById('error_message').value = "Missing required fields.";
                error = true;
            }
            if (error == false) {
                document.getElementById('error_message').value = "";
            }
        }
    </script>
</body>

</html>