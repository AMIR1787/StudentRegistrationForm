package com.example.studentregistrationform;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    public void adminpage() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader( HelloApplication.class.getResource("Registration.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage st = new Stage();
        st.setScene(scene);
        st.show();
    }
}
