package com.example.studentregistrationform;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

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
    private TextField studf;
    @FXML
    private TextField studln;
    @FXML
    private TextField studid;
    @FXML
    private TextField date;
    @FXML
    private TextField gender;
    @FXML
    private TextField mobil;
    @FXML
    private TextField email;
    @FXML
    private TableView<users> tbl;

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 421);
        Stage st = (Stage) ((Node) event.getSource()).getScene().getWindow();
        st.setScene(scene);
        st.show();

    }

    @FXML
    void register(ActionEvent event) throws ClassNotFoundException, SQLException {
        DbConnection db = new DbConnection();
        Connection con = null;
        con = DbConnection.connMethod();
        String sql = "Insert into REGISTER_TABLE (STUD_FNAME,STUD_LNAME,STUD_ID,  DATE_OF_BIRTH, GENDER,MOBILE_NO,EMAIL ) Values (?,?,?,?,?,?,?)";
        String a = studf.getText();
        String b = studln.getText();
        String c = studid.getText();
        String d = date.getText();
        String E = gender.getText();
        String f = mobil.getText();
        String g = email.getText();
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, a);
            ps.setString(2, b);
            ps.setString(3, c);
            ps.setString(4, d);
            ps.setString(5, E);
            ps.setString(6, f);
            ps.setString(7, g);
            int i = ps.executeUpdate();
            if (i == 1) {

                JOptionPane.showMessageDialog(null, "inserted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void refresh(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Admin.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 787, 550);
        Stage stg = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }

    @FXML
    void removepage(ActionEvent event) {


        DbConnection db = new DbConnection();
        PreparedStatement prs;
        String lbl = studid.getText();
        String sql = "DELETE FROM REGISTER_TABLE WHERE STUD_ID='" + lbl + "'";
        try {
            Connection con = DbConnection.connMethod();
            prs = con.prepareStatement(sql);
            prs.executeUpdate();

            JOptionPane.showMessageDialog(null, "Deleted succsecfully");
        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }

    @FXML
    void update(ActionEvent event) throws ClassNotFoundException {
        DbConnection db = new DbConnection();
        try {
            Connection con = DbConnection.connMethod();
            String value = studf.getText();
            String value1 = studln.getText();
            String value2 = studid.getText();
            String value3 = date.getText();
            String value4 = gender.getText();
            String value5 = mobil.getText();
            String value6 = email.getText();

            String sql = "update REGISTER_TABLE set STUD_FNAME = '" + value + "', STUD_LNAME = '" + value1 + "', STUD_ID = '" + value2 + "'," +
                    " DATE_OF_BIRTH = '" + value3 + "', GENDER = '" + value4 + "', MOBILE_NO = '" + value5 + "'," +
                    " EMAIL = '" + value6 + "' where STUD_ID = '" + value2 + "' ";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

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

