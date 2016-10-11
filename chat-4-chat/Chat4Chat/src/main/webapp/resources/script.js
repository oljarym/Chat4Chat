$(document).ready(function () {

    alert("hello js");


    $("#register-submit").click(function () {
        var userName = $("#register-name").val();
        var userEmail = $("#register-email").val();
        var userPassword = $("#register-password").val();
        var jsonObject = {
            "email": userEmail,
            "name": userName,
            "password": userPassword,
            "authority": "ROLE_USER"
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






    });



});