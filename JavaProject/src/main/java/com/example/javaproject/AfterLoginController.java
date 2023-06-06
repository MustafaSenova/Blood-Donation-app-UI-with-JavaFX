package com.example.javaproject;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class AfterLoginController implements Initializable{
    Hastane hastane=new Hastane();

    @FXML
    private Label uyari;

    @FXML
    private TableColumn<Donor, String> ad_after_table;

    @FXML
    private TableColumn<Donor, String> soyad_after_table;
    @FXML
    private TableView<Donor> table;

    @FXML
    private Label ad_after;

    @FXML
    private Label bagis_zaman1;
    @FXML
    private Button cikis_after;

    @FXML
    private TableColumn<Donor,String> email_after;

    @FXML
    private TableColumn<Donor, String> kan_after;

    @FXML
    private Label soyad_after;

    @FXML
    private TableColumn<Donor, String> tc_after;

    @FXML
    private Label bagis_zaman;
    @FXML
    private Label tcafter;

    @FXML
    private TableColumn<Donor,String> tel_after;


    @FXML
    void bagiscilar_fonk(ActionEvent event) {
        uyari.setText("Bağışta bulunduğunuz için teşekkürler");

        try {
            hastane.hastane_olustur();
            hastane.tarih_olustur();
            bagis_zaman.setText("Sayın "+Array.isim.get(Array.index.get(0))+" "+Array.soyisim.get(Array.index.get(0)));
            bagis_zaman1.setText(Array.hastanearr.get(Array.index.get(0))+"nde "+ Array.tarih.get(Array.index.get(0))+" tarihinde Randevunuz olusturulmustur!");
            Donor bagisci = new Donor(Array.isim.get(Array.index.get(0)),Array.soyisim.get(Array.index.get(0)),Array.kan.get(Array.index.get(0)),
                    Array.emailarr.get(Array.index.get(0)),Array.tcarr.get(Array.index.get(0)),Array.tel.get(Array.index.get(0))
            );
            ObservableList<Donor> bagiscilar = table.getItems();
            bagiscilar.add(bagisci);
            table.setItems(bagiscilar);
        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }

    }

    @FXML
    void cikis_fonk(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
            Stage window = (Stage) cikis_after.getScene().getWindow();
            window.setScene(new Scene(root,700,467));
            window.setResizable(false);
        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }
    }

    @FXML
    void tab(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ad_after.setText(Array.isim.get(Array.index.get(0)));
        soyad_after.setText(Array.soyisim.get(Array.index.get(0)));
        tcafter.setText(Array.tcarr.get(Array.index.get(0)));
        ad_after_table.setCellValueFactory(new PropertyValueFactory<Donor,String>("name"));
        email_after.setCellValueFactory(new PropertyValueFactory<Donor,String>("email"));
        soyad_after_table.setCellValueFactory(new PropertyValueFactory<Donor,String>("surname"));
        kan_after.setCellValueFactory(new PropertyValueFactory<Donor,String>("bloodType"));
        tc_after.setCellValueFactory(new PropertyValueFactory<Donor,String>("tc"));
        tel_after.setCellValueFactory(new PropertyValueFactory<Donor,String>("phone"));

    }
}
