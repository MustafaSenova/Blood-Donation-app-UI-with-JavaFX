package com.example.javaproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;



public class SignUpController {
    private String adText;
    private String sehirText;
    private String adresText;
    private String soyadText;
    private String emailText;
    private String tcText;
    private String sifreText;
    private String telText;
    private String ulkeText;
    private String kanText;

    @FXML
    private Label kayitbitim;

    @FXML
    private TextField kan;
    @FXML
    private TextField ad;

    @FXML
    private TextField adres;

    @FXML
    private TextField email;

    @FXML
    private Button girisdon;

    @FXML
    private Button kayitOl;

    @FXML
    private TextField sehir;

    @FXML
    private PasswordField sifre;

    @FXML
    private PasswordField sifreTekrar;

    @FXML
    private TextField soyad;

    @FXML
    private TextField tc;

    @FXML
    private TextField tel;

    @FXML
    private TextField ulke;

    @FXML
    private Label uyari;
    public boolean kayitkont1,kayitkont2,kayitkont3,kayitkont4,kayitkont5,kayitkont6,kayitkont7,kayitkont8,kayitkont9,kayitkont10;



    @FXML
    void Kan(ActionEvent event) {
        this.kanText=kan.getText();
        try {
            if (kanText.equals("A Rh(+)") || kanText.equals("B Rh(+)") || kanText.equals("A Rh(-)") || kanText.equals("B Rh(-)") || kanText.equals("0 Rh(-)") || kanText.equals("0 Rh(+)") || kanText.equals("AB Rh(-)") || kanText.equals("AB Rh(+)")){
                kayitkont10=true;
                uyari.setText("");
            }
            else {
                uyari.setText("Kan grubunu yanlış şekilde girdiniz! Örn: A Rh(+)");
            }

        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }

    }

    @FXML
    void SifreTekrar(ActionEvent event) {
        String sifreTekrarText = sifreTekrar.getText();
        try {
            if (sifreTekrarText.equals(sifreText)){
                uyari.setText("");
                kayitkont1=true;
            }
            else {
                uyari.setText("Girdiğiniz şifreler uyuşmuyor!");
                kayitkont1=false;
            }
        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }

    }

    @FXML
    void fonkAd(ActionEvent event) {
        this.adText=ad.getText();
        try {
            if(adText.length()==0){
                uyari.setText("Ad bilgisi boş bulunamaz!");
                kayitkont2=false;
            }
            for (int i =0; i< adText.length();i++){
                if(Character.isLetter(adText.charAt(i))){
                    uyari.setText("");
                    kayitkont2=true;
                }
                else {
                    uyari.setText("Ad bilgisinde numara bulunamaz !");
                    kayitkont2=false;
                }
            }

        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }

    }

    @FXML
    void fonkAdres(ActionEvent event) {
        this.adresText=adres.getText();
        try {
            if(adresText.length()==0){
                uyari.setText("Adres bilgisi boş bulunamaz!");
                kayitkont3=false;
            }
            else {
                uyari.setText("");
                kayitkont3=true;
            }

        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));

        }

    }

    @FXML
    void fonkEmail(ActionEvent event) {
        this.emailText=email.getText();

    }


    @FXML
    void fonkKayit(ActionEvent event) throws IOException, InterruptedException {

        if (kayitkont1 && kayitkont2 && kayitkont3 && kayitkont4 && kayitkont5 && kayitkont6 && kayitkont7 && kayitkont8 && kayitkont9 && kayitkont10){
            new Donor(adText,soyadText,adresText,emailText,sifreText,kanText,tcText,sehirText,ulkeText,telText);
            kayitbitim.setText("Kayıt Başarılı !");
            try {
                File dosya=new File("bagiscilar.txt");
                if(dosya.createNewFile()){
                    System.out.println("Dosya olusturuldu : "+dosya.getName() );
                }
                BufferedWriter yaz = new BufferedWriter(new FileWriter("bagiscilar.txt"));
                for (int i =0;i<Array.tcarr.size();i++){
                    yaz.append(Array.isim.get(i)).append(" ").append(Array.soyisim.get(i)).append(" ").append(Array.tcarr.get(i)).append(" ").append(Array.tel.get(i)).append(" ").append(Array.adres.get(i)).append(" ").append(Array.kan.get(i)).append(" ").append(Array.emailarr.get(i)).append(" ").append(Array.sifre.get(i)).append(" ").append(Array.ulke.get(i)).append(" ").append(Array.sehir.get(i));
                    yaz.newLine();
                }
                yaz.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            Thread.sleep(1500);
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
            Stage window = (Stage) girisdon.getScene().getWindow();
            window.setScene(new Scene(root,700,467));
            window.setResizable(false);

        }
        else {
            uyari.setText("Kayıt olunamadı ! Lütfen bilgilerinizi kontrol edin.");
        }

    }

    @FXML
    void fonkSehir(ActionEvent event) {
        this.sehirText=sehir.getText();
        try {
            for (int i =0; i< sehirText.length();i++){
                if(Character.isLetter(sehirText.charAt(i))){
                    uyari.setText("");
                    kayitkont4=true;
                }
                else {
                    uyari.setText("Şehir bilgisinde numara bulunamaz !");
                    kayitkont4=false;
                }
            }
            if(sehirText.length()==0){
                uyari.setText("Şehir bilgisi boş bulunamaz!");
                kayitkont4=false;
            }

        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }


    }

    @FXML
    void fonkSifre(ActionEvent event) {
        this.sifreText=sifre.getText();

        try {
            if(sifreText.length()==0){
                uyari.setText("Şifre bilgisi boş bulunamaz!");
                kayitkont5=false;
            }
            else if (sifreText.length()<=6 || sifreText.length()>=14){
                    uyari.setText("Şifre uzunluğu 6-14 arasında olmalıdır!");
                    kayitkont5=false;
            }
            else {
                uyari.setText("");
                kayitkont5=true;
            }


        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }
    }

    @FXML
    void fonkSoyad(ActionEvent event) {
        this.soyadText=soyad.getText();
        try {
            if(soyadText.length()==0){
                uyari.setText("Soyad bilgisi boş bulunamaz!");
                kayitkont6=false;
            }
            for (int i =0; i< soyadText.length();i++){
                if(Character.isLetter(soyadText.charAt(i))){
                    uyari.setText("");
                    kayitkont6=true;
                }
                else {
                    uyari.setText("Soyad bilgisinde numara bulunamaz !");
                    kayitkont6=false;
                }
            }


        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }

    }

    @FXML
    void fonkTel(ActionEvent event) {
        this.telText =tel.getText();
        try {
            if(telText.length()!=10){
                uyari.setText("Girdiğiniz numara 10 haneli olmalı ve başında 0 olmamalıdır!");
                kayitkont7=false;
            }
            else {
                uyari.setText("");
                kayitkont7=true;
            }
            for (int i =0; i< telText.length();i++){
                if(Character.isLetter(telText.charAt(i))){
                    uyari.setText("Telefon Numarasinda karakter bulunamaz");
                    kayitkont7=false;
                }
                else {
                    if (uyari.getText().equals("Girdiğiniz numara 10 haneli olmalı ve başında 0 olmamalıdır!")){
                        continue;
                    }
                    else {
                        uyari.setText("");
                    }

                }
            }


        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }
    }

    @FXML
    void fonkUlke(ActionEvent event) {
        this.ulkeText=ulke.getText();
        try {
            if (ulkeText.length()==0){
                uyari.setText("Ülke bilgisi boş bulunamaz");
                kayitkont8=false;
            }
            for (int i =0; i< ulkeText.length();i++){
                if(Character.isLetter(ulkeText.charAt(i))){
                    uyari.setText("");
                    kayitkont8=true;
                }
                else {
                    uyari.setText("Ülke bilgisinde numara bulunamaz!");
                    kayitkont8=false;
                }
            }


        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }


    }

    @FXML
    void fonktc(ActionEvent event) {
        this.tcText = tc.getText();
        try {
            for(int i = 0;i<Array.tcarr.size();i++) {
                if (tcText.equals(Array.tcarr.get(i))) {
                    uyari.setText("Bu kullanici kayitli!");
                    kayitkont9 = false;
                    break;
                }
                else {
                    uyari.setText(" ");
                }
            }
            if(tcText.length()!=11){
                uyari.setText("T.C.No'su 11 haneli olmalidir");
            }
            else{
                uyari.setText("");
                kayitkont9=true;
            }
            for (int i =0; i< tcText.length();i++){
                if(Character.isLetter(tcText.charAt(i))){
                    uyari.setText("T.C. No'sunda karakter bulunamaz");
                    kayitkont9=false;
                }
            }

        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }

    }

    @FXML
    void girisdon(ActionEvent event) {
        uyari.setText("Giriş Ekranına Yönlendiriliyorsunuz..");
        try {
            Thread.sleep(1500);
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
            Stage window = (Stage) girisdon.getScene().getWindow();
            window.setScene(new Scene(root,700,467));
            window.setResizable(false);
        }
        catch (Exception e){
            uyari.setText(String.valueOf(e));
        }

    }

}
