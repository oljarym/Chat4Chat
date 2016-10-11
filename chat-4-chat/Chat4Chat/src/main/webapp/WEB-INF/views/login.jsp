<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<style>
body {
    background: #f8f8f8;
    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
    text-align: center;
    color: #fff;
    padding-top: 0;
}

.login-container {
    margin: 120px auto 0 auto;
}

h1 {
    font-size: 30px;
    font-weight: 700;
    text-shadow: 0 1px 4px rgba(0,0,0,.2);
}

form {
    position: relative;
    width: 305px;
    margin: 15px auto 0 auto;
    text-align: center;
}

input {
    width: 270px;
    height: 42px;
    margin-top: 25px;
    padding: 0 15px;
    background: #2d2d2d; /* browsers that don't support rgba */
    background: rgba(45,45,45,.15);
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #3d3d3d; /* browsers that don't support rgba */
    border: 1px solid rgba(255,255,255,.15);
    -moz-box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    -webkit-box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset;
    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
    font-size: 14px;
    color: darkblue;
    text-shadow: 0 1px 2px rgba(0,0,0,.1);
    -o-transition: all .2s;
    -moz-transition: all .2s;
    -webkit-transition: all .2s;
    -ms-transition: all .2s;
}

input:-moz-placeholder { color: #fff; }
input:-ms-input-placeholder { color: #fff; }
input::-webkit-input-placeholder { color: #fff; }

input:focus {
    outline: none;
    -moz-box-shadow:
            0 2px 3px 0 rgba(0,0,0,.1) inset,
            0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
            0 2px 3px 0 rgba(0,0,0,.1) inset,
            0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:
            0 2px 3px 0 rgba(0,0,0,.1) inset,
            0 2px 7px 0 rgba(0,0,0,.2);
}

button {
    cursor: pointer;
    width: 300px;
    height: 44px;
    margin-top: 25px;
    padding: 0;
    background: #ef4300;
    -moz-border-radius: 6px;
    -webkit-border-radius: 6px;
    border-radius: 6px;
    border: 1px solid #ff730e;
    -moz-box-shadow:
            0 15px 30px 0 rgba(255,255,255,.25) inset,
            0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
            0 15px 30px 0 rgba(255,255,255,.25) inset,
            0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:
            0 15px 30px 0 rgba(255,255,255,.25) inset,
            0 2px 7px 0 rgba(0,0,0,.2);
    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
    font-size: 14px;
    font-weight: 700;
    color: #fff;
    text-shadow: 0 1px 2px rgba(0,0,0,.1);
    -o-transition: all .2s;
    -moz-transition: all .2s;
    -webkit-transition: all .2s;
    -ms-transition: all .2s;
}

button:hover {
    -moz-box-shadow:
            0 15px 30px 0 rgba(255,255,255,.15) inset,
            0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
            0 15px 30px 0 rgba(255,255,255,.15) inset,
            0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:
            0 15px 30px 0 rgba(255,255,255,.15) inset,
            0 2px 7px 0 rgba(0,0,0,.2);
}

button:active {
    -moz-box-shadow:
            0 15px 30px 0 rgba(255,255,255,.15) inset,
            0 2px 7px 0 rgba(0,0,0,.2);
    -webkit-box-shadow:
            0 15px 30px 0 rgba(255,255,255,.15) inset,
            0 2px 7px 0 rgba(0,0,0,.2);
    box-shadow:
            0 5px 8px 0 rgba(0,0,0,.1) inset,
            0 1px 4px 0 rgba(0,0,0,.1);

    border: 0px solid #ef4300;
}



.error span {
    display: inline-block;
    margin-left: 2px;
    font-size: 40px;
    font-weight: 700;
    line-height: 40px;
    text-shadow: 0 1px 2px rgba(0,0,0,.1);
    -o-transform: rotate(45deg);
    -moz-transform: rotate(45deg);
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);

}


.connect a {
    display: inline-block;
    width: 32px;
    height: 35px;
    margin-top: 15px;
    -o-transition: all .2s;
    -moz-transition: all .2s;
    -webkit-transition: all .2s;
    -ms-transition: all .2s;
}

</style>

<div class="page-login">
<div class="login-container">
    <form  name='f' action="${pageContext.request.contextPath}/login" method='post'>
        <h1>Login</h1>
        <div class="form-group">
            <label for="login-email"><span class="glyphicon glyphicon-user"></span>User name</label>
            <input type="email" class="form-control required" name='username' id="login-email" placeholder="Enter email">
        </div>
        <div class="form-group">
            <label for="login-password"><span class="glyphicon glyphicon-eye-open"></span> Password</label>
            <input  class="form-control required" type='password' name='password' id="login-password" placeholder="Enter password">
        </div>
        <input name="submit" type="submit" class="btn btn-block" value="Log in"/>

        <input name="_csrf" type="hidden" value="982d7ddb-3b5b-4480-8a39-ffae2f3dd875"/>
    </form>
</div>
</div>