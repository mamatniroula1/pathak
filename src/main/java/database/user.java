package database;

import java.sql.*;

public class user {
    String query="Select * from logindemo where username=? and password=? ";
    String url="jdbc:mysql://localhost:3306/cubic";
    String username= "root";
    String password="";
    public boolean check( String user, String pass) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection(url, username, password);
        PreparedStatement preparedStatement= connection.prepareStatement(query);
        preparedStatement.setString(1,user);
        preparedStatement.setString(2,pass);
        ResultSet resultSet= preparedStatement.executeQuery();



        while(resultSet.next()){

            return  true;
        }

        return  false;
    }

//    public static void main(String[] args) throws SQLException {
//        user user= new user();
//        System.out.println(user.check("paasdsathak", "bhaskar"));
//    }

}
