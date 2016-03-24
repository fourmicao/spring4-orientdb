<!doctype html>
<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Success Registered web </title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="<core:url value="/resources/bootstrap.css" />" rel="stylesheet">

    <script type="text/javascript" src="/resources/jquery-1.7.2.min.js"></script>

    <script type="text/javascript">

        $( document ).ready(function() {
            console.log( "ready!" );
        });

    </script>
</head>
<body>
<div class="container">

    <div style="margin-top:20px"></div>

    <form id="myform">
        <label for="field">Required, us phone number: </label>
        <input class="left" id="field" name="field">
        <br/>
        <input type="submit" value="Validate!">
    </form>

</div>
</body>
</html>