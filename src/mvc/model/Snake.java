package mvc.model;

import java.sql.*;

public class Snake {
    private PreparedStatement preparedStatement;
    private Connection con;

    public Snake() {
        connect();
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/snake", "root", "antim");

        } catch(Exception ex) {
            System.out.println("CONNECTION ERROR:"+ex.getMessage());
            ex.printStackTrace();
        }
    }

    public void addSnakeMove(String ground_width, String ground_height, String food_x, String food_y, String snake_x, String snake_y, String snake_length, String snake_direction, String timeAt, String username) {
        try {
            preparedStatement = con.prepareStatement("INSERT INTO Snake (groundWidth, groundHeight, foodX," +
                    "foodY, snakeX, snakeY, snakeLength, snakeDirection, timeAt, username) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1,ground_width);
            preparedStatement.setString(2,ground_height);
            preparedStatement.setString(3,food_x);
            preparedStatement.setString(4,food_y);
            preparedStatement.setString(5,snake_x);
            preparedStatement.setString(6,snake_y);
            preparedStatement.setString(7,snake_length);
            preparedStatement.setString(8,snake_direction);
            preparedStatement.setString(9,timeAt);
            preparedStatement.setString(10, username);
            System.out.println(ground_width + " " + ground_height+ " " + food_x+ " " + food_y+ " " + snake_x+ " " + snake_y+ " " + snake_length+ " " + snake_direction+ " " + timeAt+ " " + username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
