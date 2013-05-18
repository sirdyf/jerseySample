<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>GlassFish JSP Page</title>
    	<script type="text/javascript">
	function button_click(){
		var url = "/jerseySample/rest/session";
	
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
  </head>
  <body>
    <h1>Hello ${it} !</h1>
	    <ul>
	      <li>
		    <a href="http://176.56.22.26:8080/jerseySample/">Главная страница</a>
		  <li>
		    <a href="http://176.56.22.26:8080/jerseySample/sendmessage.html"> послать сообщение</a>
		  <li>
		    <a href="http://176.56.22.26:8080/jerseySample/rest/messages/"> список всех сообщений за сеанс</a>
<!-- 		  <li> -->
<!-- 		    <a href="http://176.56.22.26:8080/jerseySample/rest/messages/id"> просмотр 1 сообщения(TODO)</a> -->
		  <li>
		    <a href="http://176.56.22.26:8080/jerseySample/rest/users/"> список всех контактов</a>
<!-- 		  <li> -->
<!-- 		    <a href="http://176.56.22.26:8080/jerseySample/rest/users/id"> список всех сообщений за сеанс</a> -->
		  </li>
	    </ul>
<!-- 	<input type='button' value='logof' onClick="button_click()"> -->
  </body>
</html> 
