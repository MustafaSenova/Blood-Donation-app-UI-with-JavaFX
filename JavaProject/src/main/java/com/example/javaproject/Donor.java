package com.example.javaproject;

public class Donor extends Person{

    public Donor(String name, String surname, String location, String email, String password, String bloodType, String tc, String city, String country, String phone) {
        super(name, surname, location, email, password, bloodType, tc, city, country, phone);
    }

    public Donor() {
    }
    public Donor(String name,String surname , String email,String bloodType,String tc,String phone){
        this.setName(name);
        this.setSurname(surname);
        this.setEmail(email);
        this.setBloodType(bloodType);
        this.setTc(tc);
        this.setPhone(phone);
    }
    @Override
    public void ridecont(){
        super.setName(getName());
    }




}
