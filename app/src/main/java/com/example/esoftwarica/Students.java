package com.example.esoftwarica;

public class Students {

    private String name;
    private int age;
    private String address;
    private String gender;
    private int imgProfile;
    private int imgBtnDel;

    //constructor
    public Students(String name, int age, String address, String gender, int imgProfile, int imgBtnDel) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.imgProfile = imgProfile;
        this.imgBtnDel = imgBtnDel;
    }

    //getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }

    public int getImgBtnDel() {
        return imgBtnDel;
    }

    public void setImgBtnDel(int imgBtnDel) {
        this.imgBtnDel = imgBtnDel;
    }
}
