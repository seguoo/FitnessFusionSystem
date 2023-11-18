package com.example.fitnessfusionsystem;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String newUsername;
    private boolean gender;
    private int age;
    private double weight;

    //default constructor
    public User() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.password = "";
        this.newUsername = "";
        this.gender = false;
        this.age = 0;
        this.weight = 0.0;
    }

    public User(String firstName, String lastName, String email, String password, String newUsername, boolean gender, int age, double weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.newUsername = newUsername;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
