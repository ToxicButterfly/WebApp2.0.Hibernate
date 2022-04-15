<%@ page import="app.model.UserDao" %>
<%@ page import="app.entities.User" %><%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Add new user</title>
</head>

<body>

<div>
    <%
        if (request.getAttribute("userName") != null) {
            out.println("<p>User '" + request.getAttribute("userName") + "' added!</p>");
        }
    %>
    <div>
        <div>
            <h2>Add user</h2>
        </div>

        <form method="post">
            <label>Name:
                <input type="text" name="name"><br />
            </label>
            <label>Password:
                <input type="password" name="pass"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>
<div>
    <button onclick="location.href='/MyWebApp'">Back to main</button>
</div>
</body>
</html>