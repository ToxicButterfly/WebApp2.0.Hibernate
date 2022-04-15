<%@ page import="java.util.ListIterator" %>
<%@ page import="app.entities.User" %>
<%@ page import="app.model.UserDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of users!</title>
</head>
<body>
<ul>
    <%
//        DaoUser dao = null;
//        try {
//            dao = new DaoUser();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        ListIterator<User> iter = dao.getAll().listIterator();
//        while(iter.hasNext()) {
//            out.println("<ui>");
//            String name = iter.next().getName();
//            out.println("<li>" + name + "</li>");
//            out.println("</ui>");
//        }
        UserDao dao = new UserDao();
        List<User> list = dao.findAll();
        ListIterator<User> iter = dao.findAll().listIterator();
        out.println("<table border = '2'>");
        while(iter.hasNext()) {
            User user = iter.next();
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getName() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");

    %>
</ul>
<div>
    <form method="post">
        <label>Delete row by id:
            <input type="text" name="id"><br />
        </label>
        <button type="submit">Submit</button>
    </form>
    <button onclick="location.href='/MyWebApp'">Back to main</button>
</div>

</body>
</html>
