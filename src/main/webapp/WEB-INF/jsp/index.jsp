<!DOCTYPE html>
<%@ taglib prefix="core" uri="http://java.sun.com/jstl/core" %>
<html>
<head lang="en">
    <meta http-equiv="content-type" content="text/html;charset=UTF8">
    <title>charting </title>
    <%--<link rel="stylesheet" href="bower_components/c3js-chart/c3.css"/>--%>
    <link href="<core:url value="/resources/c3.css" />" rel="stylesheet">

    <style>
        h1 {
            text-align: center;
        }
    </style>
</head>
<body>


<div id="chart">
</div>

<div>
    <h1 id="text"></h1>
</div>
<script type="text/javascript" src="/resources/d3.js" charset="utf-8"></script>
<script type="text/javascript" src="/resources/c3.js" charset="utf-8"></script>

<script type="text/javascript" src="/resources/poll.js" charset="utf-8"></script>

<%-- this example is borrowed from http://jocellyn.cz/2014/07/25/simple-charts-with-c3.html--%>
<script type="text/javascript">

    var chart = c3.generate({
        data: {
            columns: [
                ['Lulu', 50],
                ['Olaf', 50],
            ],
            type : 'donut'
        },
        donut: {
            title: "Dogs love:",
        }
    });

</script>
</body>
</html>