package com.example.studentregistrationform;
import java.sql.*;
public class DBConnection {
    final static String URL= "";
    final static String USER= "";
    final static String PASS = "";
    final static String DRIVER= "";
    Connection conn = null;
    public Connection conectionMEthod() throws ClassNotFoundException {
        Class.forName(DRIVER);
        try{




        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
