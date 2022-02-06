package com.example.studentregistrationform;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {

    public void register() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication.class.getResource("Registration.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage st = new Stage();
        st.setScene(scene);
        st.show();
    }
    public void  removepage() throws IOException{
FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("Remover.fxml"));
Scene scene=new Scene(fxmlLoader.load(),600,400);
Stage st=new Stage();
st.setScene(scene);
st.show();
    }


}
