<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<html>
<head>
    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css"/>
    <title><tiles:insertAttribute name="title"/></title>
</head>
<body>
<div class="header">
    <tiles:insertAttribute name="header"/>
</div>

<div class="body">
    <tiles:insertAttribute name="body"/>
</div>

<div class="footer">
    <tiles:insertAttribute name="footer"/>
</div>
</body>
</html>