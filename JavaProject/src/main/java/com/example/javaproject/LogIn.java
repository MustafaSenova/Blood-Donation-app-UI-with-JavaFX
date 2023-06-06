package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LogIn {


    @FXML
    private Label uyari_log;

    @FXML
    private Label kayit;

    @FXML
    private Button login;

    @FXML
    private PasswordField sifre;

    @FXML
    private TextField tc;

    private String tcText_log,sifreText_log;

    private boolean kayitkont1,kayitkont2;

    public int index;


    @FXML
    void cikis(ActionEvent event) {
        System.exit(0);

    }
    @FXML
    void Kayit(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SignUp.fxml")));
        Stage window = (Stage) kayit.getScene().getWindow();
        window.setScene(new Scene(root,751,421));
        window.setResizable(false);


    }

    @FXML
    void Login(ActionEvent event) {
        System.out.println(Array.isim);
        System.out.println(Array.soyisim);
        System.out.println(Array.emailarr);
        System.out.println(Array.tel);
        System.out.println(Array.kan);
        System.out.println(Array.tcarr);
        System.out.println(Array.adres);
        System.out.println(Array.sehir);
        System.out.println(Array.sifre);
        System.out.println(Array.ulke);
        System.out.println(Array.hastanearr);
        System.out.println(Array.tarih);
        try {
            if(kayitkont1 && kayitkont2){
                uyari_log.setText("Giriş Yapıldı !");
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("afterLogin.fxml")));
                Stage window = (Stage) login.getScene().getWindow();
                window.setScene(new Scene(root,700,467));
                window.setResizable(false);
            }
            else {
                uyari_log.setText("Giriş Yapılamadı! Bilgilerinizi kontrol ediniz.");
            }

        }
        catch (Exception e){
            uyari_log.setText(String.valueOf(e));
        }

    }

    @FXML
    void Sifre(ActionEvent event) {
        this.sifreText_log=sifre.getText();
        try {
            if(sifreText_log.length()==0){
                uyari_log.setText("Şifre bilgisi boş bulunamaz!");
                kayitkont2=false;
            }
            else if (sifreText_log.length()<=6 || sifreText_log.length()>=14){
                uyari_log.setText("Şifre uzunluğu 6-14 arasında olmalıdır!");
                kayitkont2=false;
            }
            if (sifreText_log.equals(Array.sifre.get(index))){
                kayitkont2=true;
                uyari_log.setText("");
            }
            else {
                uyari_log.setText("T.C Kimlik No veya Şifre hatalı !");
                kayitkont2=false;
            }


        }
        catch (Exception e){
            uyari_log.setText(String.valueOf(e));
        }


    }

    @FXML
    void Tc(ActionEvent event) {
        this.tcText_log=tc.getText();
        try {
            for(int i = 0;i<Array.tcarr.size();i++){
                if(Array.tcarr.get(i).equals(tcText_log)){
                    this.index=Array.tcarr.indexOf(tcText_log);
                    Array.index.clear();
                    Array.index.add(index);
                    kayitkont1=true;
                    uyari_log.setText(" ");
                    break;

                }
                else {
                    uyari_log.setText("Kullanıcı kayıtlı değil !");
                    kayitkont1=false;
                }
            }

            if(tcText_log.length()!=11){
                uyari_log.setText("T.C.No'su 11 haneli olmalidir");
            }
            else{
                uyari_log.setText("");
                kayitkont1=true;
            }
            for (int i =0; i< tcText_log.length();i++){
                if(Character.isLetter(tcText_log.charAt(i))){
                    uyari_log.setText("T.C. No'sunda karakter bulunamaz");
                    kayitkont1=false;
                }
            }

        }
        catch (Exception e){
            uyari_log.setText(String.valueOf(e));
        }


    }

}
