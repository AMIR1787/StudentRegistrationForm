package com.example.studentregistrationform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    @FXML
    private PasswordField PASSWORD;

    @FXML
    private TextField USERNAME;
    @FXML
    private Button log;

     @FXML
     private Button cancl;


    @FXML
    void loginbut(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
   if(USERNAME.getText().isBlank()==false &&PASSWORD.getText().isBlank()==false){
       validate();
   }
  else{
       if(USERNAME.getText().equals("")||PASSWORD.equals("")){

           JOptionPane.showMessageDialog(null,"every filled is required");
       }

   }



    }

    public void Cancelbut(ActionEvent actionEvent) throws ClassNotFoundException{
       Stage stage=(Stage) cancl.getScene().getWindow();
       stage.close();

    }
    public void validate() throws ClassNotFoundException {
        DbConnection db=new DbConnection();
        Connection con=db.connMethod();
        String sql="select * from ADMIN_TABLE ";

       try{
           Statement st=con.createStatement();
           ResultSet rs=st.executeQuery(sql);
   while (rs.next()){
       if((rs.getString(1).equals(USERNAME.getText())) && (rs.getString(2).equals(PASSWORD.getText())))  {
           FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin.fxml"));
           Scene scene = new Scene(fxmlLoader.load(), 600, 400);
           Stage stg =new Stage();
           stg.setScene(scene);
           stg.show();
       }
       else{



           JOptionPane.showMessageDialog(null,"please enter correct username and password");
          USERNAME.setText("");
          PASSWORD.setText("");



       }
   }
       }catch (Exception e){
           e.printStackTrace();
       }

    }




}




