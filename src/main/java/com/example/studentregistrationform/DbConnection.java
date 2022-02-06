package com.example.studentregistrationform;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static final String url="jdbc:oracle:thin:@localhost:1521:xe";
    public static final String user="DB CON";
    public static final String password="aj1787";
    public static final String driver="oracle.jdbc.driver.OracleDriver";


    public static Connection connMethod() throws ClassNotFoundException{
     Class.forName(driver);
     Connection con=null;
        try {
            con=DriverManager.getConnection(url,user,password);
        //System.out.println("connected");
             } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;  }
  public static void main(String[] args) throws ClassNotFoundException {
    //DbConnection db=new DbConnection();
    //Connection con=db.connMethod();
  }
}

