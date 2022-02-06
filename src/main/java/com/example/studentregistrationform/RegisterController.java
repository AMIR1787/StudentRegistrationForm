package com.example.studentregistrationform;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    public void backtoreg() throws IOException{
        FXMLLoader fxmlLoader=new FXMLLoader(HelloApplication.class.getResource("Admin.fxml"));
        Scene scene=new Scene(fxmlLoader.load(),600,400);
        Stage st=new Stage();
        st.setScene(scene);
        st.show();
    }

}
