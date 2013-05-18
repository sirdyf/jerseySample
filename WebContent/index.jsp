<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    	               "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>GlassFish JSP Page</title>
  </head>
  <body>
    <h1>Hello World!</h1>
	  <p>REST маршруты:</p>
	    	<b>POST /messages -послать сообщение @FormParam("name"),@FormParam("mess")</b>
	    <br>
	    	<b>GET /messages -просмотр всех сообщений</b>
	    <br>
	    	<b>DELETE /messages -удаление всех сообщений</b>
	    <br>
	    	<b>GET /messages/{id} -просмотр одного сообщения(TODO)</b>
	    <br>
	    	<b>POST /logon -авторизация</b>
	    <br>
	    	<b>GET /users -список контактов</b>
	    <br>
	    	<b>GET /users/{name} -информация о контакте(TODO)</b>
	    <br>
	    	<b>GET /users/{name}/messages -сообщения контакта(TODO)</b>
	  <p>
	    <ul>
		  <li>
		    <a href="http://176.56.22.26:8080/jerseySample/logon.html"> авторизация на OpenFire</a>
		  </li>
	    </ul>
  </body>
</html> 
