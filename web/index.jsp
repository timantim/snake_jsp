<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if(session.isNew() || session.getAttribute("user") == null)
    response.sendRedirect("/login.html");
  else
    response.sendRedirect("/snake.jsp");
%>
<html>
  <head>
    <title></title>
  </head>
  <body>

  </body>
</html>
