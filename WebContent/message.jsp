<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<script language="JavaScript" type="text/javascript">
	function fresh() {
		location.reload();
	}
	setInterval("fresh()",3000);
		
	function button_click(){
		var url = "/jerseySample/rest/messages";
	
		var client = new XMLHttpRequest();
	
		client.open("DELETE", url);
		client.onreadystatechange = function(){
			if (client.readyState != 4) return;
			if (client.status == 200){
				location.reload();
			}else{
				alert("The request did not succeed!\n\nThe response status was: " + client.status + " " + client.statusText + ".");
			}
		};
		client.send(null); 
	}
	</script>
<head>
  <title>Welcome!</title>
</head>
<body>
  <h1>All messages</h1>
  <p>
    items in your message :<br />
    <c:forEach var="item" items="${it}">
        ${item}<br />
    </c:forEach>
  </p>
	<input type='button' value='clear history' onClick="button_click()">
	<br>
		<a href="http://176.56.22.26:8080/jerseySample/rest/session">home</a>
</body>
</html>
