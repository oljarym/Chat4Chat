

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="<spring:url value="/static/style.css"/>" type="text/css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<br>
<br>
<br>
<br>
<br>
<style>
    .register-form {
        padding-bottom: 40%;
        padding-left: 30%;
        padding-right:30%;

    }
</style>

<div class="register-form" style="align-content: center">
    <form  action="${pageContext.request.contextPath}/login" method='post'>
        <div class="form-group">
            <label for="register-name"><span class="glyphicon glyphicon-user"></span> Name: </label>
            <input type="text" class="form-control required" id="register-name" name="name">
        </div>
        <div class="form-group">
            <label for="register-email"><span class="glyphicon glyphicon-send"></span> Email: </label>
            <input  class="form-control required" type='email' id="register-email" name="email">
        </div>
        <div class="form-group">
            <label for="register-password"><span class="glyphicon glyphicon-eye-open"></span> Password: </label>
            <input  class="form-control required" type='password' id="register-password" name="password1">
        </div>
        <div class="form-group">
            <label for="register-password-confirm"><span class="glyphicon glyphicon-eye-open"></span> Confirm Password: </label>
            <input  class="form-control required" type='password' id="register-password-confirm" name="password2" >
        </div>
        <div class="form-group">
            <div id="massages"></div>
        </div>
        <input type="submit" id="register-submit" value="Register Me" class="btn btn">

    </form>
</div>
<script>
    $(document).ready(function () {
        $("#register-submit").click(function () {
            var userName = $("#register-name").val();
            var userEmail = $("#register-email").val();
            var userPassword = $("#register-password").val();
            var jsonObject = {
                "email": userEmail,
                "name": userName,
                "password": userPassword,
                "authority": "ROLE_USER",
                "openPage": true,
                "enabled" : true
            };

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/users/",
                contentType: 'application/json; charset=utf-8',
                data: JSON.stringify(jsonObject),
                statusCode: {
                    201: function () {
                        alert("Account was created");
                        window.location = '/login'
                    } /*,
                     400: function () {
                     alert("Failed. Please, try again!");
                     } */
                }
            });
        })
    });

</script>




</body>
</html>
