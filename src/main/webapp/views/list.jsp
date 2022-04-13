<%@ page import="java.util.List" %>
<%@ page import="java.util.ListIterator" %>
<%@ page import="app.model.DaoUser" %>
<%@ page import="app.entities.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users!</title>
</head>
<body>
<ul>
    <%
        DaoUser dao = null;
        try {
            dao = new DaoUser();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //      List<String> names = (List<String>) request.getAttribute("userNames");
        ListIterator<User> iter = dao.getAll().listIterator();
        while(iter.hasNext()) {
            out.println("<ui>");
            String name = iter.next().getName();
            out.println("<li>" + name + "</li>");
            out.println("</ui>");
        }
    %>
</ul>
<div>
    <button onclick="location.href='/MyWebApp/'">Back to main</button>
</div>

</body>
</html>
