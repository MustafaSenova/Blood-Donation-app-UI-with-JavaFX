package com.example.javaproject;


public abstract class Person {


    public Person(String name, String surname, String location, String email, String password, String bloodType, String tc, String city, String country, String phone) {
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.email = email;
        this.password = password;
        this.bloodType = bloodType;
        this.tc = tc;
        this.city = city;
        this.country = country;
        this.phone = phone;
        Array.isim.add(name);
        Array.soyisim.add(surname);
        Array.adres.add(location);
        Array.emailarr.add(email);
        Array.sifre.add(password);
        Array.kan.add(bloodType);
        Array.tcarr.add(tc);
        Array.sehir.add(city);
        Array.ulke.add(country);
        Array.tel.add(phone);
    }

    public Person() {

    }

    private String name;
    private String surname;
    private String location;
    private String email;
    private String password;
    private String bloodType;
    private String tc;
    private String city;
    private String country;
    private String phone;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void ridecont(){
        System.out.println("Override");

    }


}
