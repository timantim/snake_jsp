package mvc.model;

import java.sql.*;

public class Authenticator {
    private PreparedStatement preparedStatement;
    private Connection con;

    public Authenticator() {
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

    public boolean authenticate(String username, String password) {

        ResultSet rs;
        boolean result = false;
        System.out.println(username+" "+password);
        try {
            preparedStatement = con.prepareStatement("select * from user where u_username=?");
            preparedStatement.setString(1, username);
            rs = preparedStatement.executeQuery();
            if (rs.next() && rs.getString("u_password").equals(password)) {
                result = true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
