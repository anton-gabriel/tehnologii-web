package db;
import models.User;

import java.sql.*;
import java.util.ArrayList;

public class ConnectionDB
{
    private static Connection myConnection = null;
    private Statement myStatement = null;
    private ResultSet myResultSet = null;

    // crearea conexiunii la baza de date, puteti face un factory pentru managementul conexiunilor sau sa faceti o clasa singleton astfel incat sa
    // nu aveti mai multe instante care incearca sa acceseze resursele

    public static Connection createConection() {
        try {
            Class.forName("org.postgresql.Driver");
            myConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users", "postgres", "1q2w3e4r");
            return myConnection;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("CONNECTION FAILED");
        } catch (Exception e) {
            e.printStackTrace();

        }
       
        return null;
    }

    public ArrayList<User> getAccounts() {
        createConection();
        ArrayList<User> users = new ArrayList<User>();
        try {
            myStatement = myConnection.createStatement();
            ResultSet rs = myStatement.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                int id = rs.getInt("personid");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String userType=rs.getString("userType");
                User user = new User(username, password,userType);
                users.add(user);
            }
            if(users.isEmpty())
            {
                System.out.println("Nu exista niciun user in  baza de date");
            }
            rs.close();
            myStatement.close();
            myConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

	public Connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(Connection myConnection) {
		this.myConnection = myConnection;
	}

	public Statement getMyStatement() {
		return myStatement;
	}

	public void setMyStatement(Statement myStatement) {
		this.myStatement = myStatement;
	}

	public ResultSet getMyResultSet() {
		return myResultSet;
	}

	public void setMyResultSet(ResultSet myResultSet) {
		this.myResultSet = myResultSet;
	}
    
}




