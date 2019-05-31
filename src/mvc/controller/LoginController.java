package mvc.controller;

import mvc.model.Authenticator;
import mvc.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginController extends HttpServlet {

    public LoginController() {
        super();
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        RequestDispatcher rd = null;

        Authenticator authenticator = new Authenticator();
        boolean result = authenticator.authenticate(username, password);
        if (result) {
            rd = request.getRequestDispatcher("/snake.jsp");
            User user = new User(username, password);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user", user);
            request.setAttribute("user", user);
        } else {
            rd = request.getRequestDispatcher("/login.jsp");
        }
        rd.forward(request, response);
    }

}
