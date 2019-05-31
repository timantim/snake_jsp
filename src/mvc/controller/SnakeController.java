package mvc.controller;

import mvc.model.Snake;
import mvc.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SnakeController extends HttpServlet {
    public SnakeController () { super(); }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {
        System.out.println("addsnakeMove!");
        String ground_width = request.getParameter("ground_width");
        String ground_height = request.getParameter("ground_height");
        String food_x = request.getParameter("food_x");
        String food_y = request.getParameter("food_y");
        String snake_x = request.getParameter("snake_x");
        String snake_y = request.getParameter("snake_y");
        String snake_length = request.getParameter("snake_y");
        String snake_direction = request.getParameter("snake_direction");
        String timeAt = request.getParameter("timeAt");
        User user = (User)request.getSession().getAttribute("user");
        String userName = user.getUsername();

        Snake s = new Snake();
        s.addSnakeMove(ground_width, ground_height, food_x, food_y, snake_x, snake_y, snake_length, snake_direction, timeAt, userName);

    }
}
