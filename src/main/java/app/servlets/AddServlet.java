package app.servlets;


import app.entities.User;
import app.model.DaoUser;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaoUser dao = null;
        try {
            dao = new DaoUser();
        } catch (ClassNotFoundException e) {
            System.out.println("Дабл Фейл");
            e.printStackTrace();
        }
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        User user = new User(name,password);
        Model model = Model.getInstance();
        model.add(user);
//        dao.save(user);
        System.out.println("ВЫВОД МОДЕЛИ: " + model.list());

        req.setAttribute("userName", name);
        doGet(req, resp);
    }
}
