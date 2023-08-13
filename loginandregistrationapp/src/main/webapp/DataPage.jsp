<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Tab</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: purple">

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/tab"
					class="nav-link">Iotdevices</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">

		<div class="container">
			<h3 class="text-center">List of Users</h3>
			<hr>
			<div class="container text-right">

				<a href="<%=request.getContextPath()%>/list" class="btn btn-success">
					Back</a>
			</div>
			<div class="container text-left">
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
            <th>Device ID</th>           
            <th>Measurement ID</th>
            <th>Value</th>
            <th>Timestamp</th>
        </tr>
    </thead>
    <tbody>
         <c:forEach var="iotdevice" items="${tabularList}">
            <c:set var="device" value="${iotdevice}" />
           
            <c:forEach var="measurement" items="${device.dataCaptured}">
                <tr>
              <%--  --%>
             	    <td><c:out value="${iotdevice.deviceId}" /></td>
                    <td><c:out value="${measurement.measurementId}" /></td>
                    <td><c:out value="${measurement.value}" /></td>
                    <td><c:out value="${measurement.timeStamp}" /></td>
                </tr>
            </c:forEach>
            
        </c:forEach>
    </tbody>
</table>   

		</div>
	</div>
</body>
</html>