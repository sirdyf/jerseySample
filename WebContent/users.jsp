<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>All contacts</h1>
  <p>
    items in your contacts :<br />
    <c:forEach var="item" items="${it}">
        ${item}<br />
    </c:forEach>
  </p>
	<br>
		<a href="http://176.56.22.26:8080/jerseySample/rest/session">home</a>
</body>
</html>
