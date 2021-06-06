package com.example.acm;

public class student_detail_model {
    private String branch;
    private String choice0;
    private String choice1;
    private String choice2;
    private String Email;
    private String name;
    private String phone;
    private String registration_year;
    private String year;
    private String haschoosen;

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public student_detail_model(String branch, String choice0, String choice1, String choice2, String email, String name, String phone, String registration_year, String year, String haschoosen) {
        this.branch = branch;
        this.choice0 = choice0;
        this.choice1 = choice1;
        this.choice2 = choice2;
        Email = email;
        this.name = name;
        this.phone = phone;
        this.registration_year = registration_year;
        this.year = year;
        this.haschoosen = haschoosen;
    }
}
