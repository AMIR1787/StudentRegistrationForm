package com.example.studentregistrationform;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudpageController implements Initializable {

    ObservableList<users> ListM = FXCollections.observableArrayList();
    @FXML
    private TableColumn<users, String> coldat;
    @FXML
    private TableColumn<users, String> colemal;
    @FXML
    private TableColumn<users, String> colgender;
    @FXML
    private TableColumn<users, String> colmob;
    @FXML
    private TableColumn<users, String> colstudfn;
    @FXML
    private TableColumn<users, String> colstudid;
    @FXML
    private TableColumn<users, String> colstudln;
    @FXML
    private TableView<users> tbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DbConnection db = new DbConnection();

    }


    public void view(ActionEvent event) {
        try {
            DbConnection db = new DbConnection();
            Connection con = DbConnection.connMethod();
            ResultSet rs = con.createStatement().executeQuery("select * from REGISTER_TABLE");
            while (rs.next()) {
                ListM.add(new users(rs.getString("STUD_FNAME"), rs.getString("STUD_LNAME"),
                        rs.getString("STUD_ID"), rs.getString("DATE_OF_BIRTH"),
                        rs.getString("GENDER"), rs.getString("MOBILE_NO"), rs.getString("EMAIL")));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        colstudfn.setCellValueFactory(new PropertyValueFactory<users, String>("STUD_FNAME"));
        colstudln.setCellValueFactory(new PropertyValueFactory<users, String>("STUD_LNAME"));
        colstudid.setCellValueFactory(new PropertyValueFactory<users, String>("STUD_ID"));
        coldat.setCellValueFactory(new PropertyValueFactory<users, String>("DATE_OF_BIRTH"));
        colgender.setCellValueFactory(new PropertyValueFactory<users, String>("GENDER"));
        colmob.setCellValueFactory(new PropertyValueFactory<users, String>("MOBILE_NO"));
        colemal.setCellValueFactory(new PropertyValueFactory<users, String>("EMAIL"));
        tbl.setItems(ListM);

    }
}
