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
	    	<b>GET /messages/{param} -просмотр одного сообщения</b>
	    <br>
	    	<b>POST /messages/logon -авторизация</b>
	    </br>
	  <p>
	    <ul>
	      <li>
		    <a href="http://localhost:8080/jerseySample/">Эта страница</a>
		  <li>
		    <a href="http://localhost:8080/jerseySample/logon.html"> авторизация на OpenFire</a>
		  <li>
		    <a href="http://localhost:8080/jerseySample/sendmessage.html"> послать сообщение</a>
		  <li>
		    <a href="http://localhost:8080/jerseySample/rest/messages/"> список всех сообщений за сеанс</a>
		  <li>
		    <a href="http://localhost:8080/jerseySample/rest/messages/id"> просмотр 1 сообщения(TODO)</a>
		  </li>
	    </ul>
	  </p>
  </body>
</html> 
