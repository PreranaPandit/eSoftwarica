package com.example.esoftwarica;

public class Students {

    private String name;
    private int age;
    private String address;
    private String gender;
    private int imageGender;
    private int imageDelete;

    //Constructor
    public Students(String name, int age, String address, String gender, int imageGender, int imageDelete) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.gender = gender;
        this.imageGender = imageGender;
        this.imageDelete = imageDelete;
    }

    //Getter and setter


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

    public int getImageGender() {
        return imageGender;
    }

    public void setImageGender(int imageGender) {
        this.imageGender = imageGender;
    }

    public int getImageDelete() {
        return imageDelete;
    }

    public void setImageDelete(int imageDelete) {
        this.imageDelete = imageDelete;
    }

    
}
