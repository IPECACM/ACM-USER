package com.example.acm;

public class facultymodel {
String F_Email,F_Name,F_Post,F_Image;

    public facultymodel(String f_Image) {
        F_Image = f_Image;
    }

    public String getF_Image() {
        return F_Image;
    }

    public void setF_Image(String f_Image) {
        F_Image = f_Image;
    }

    public facultymodel(String f_Email, String f_Name, String f_Post) {
        F_Email = f_Email;
        F_Name = f_Name;
        F_Post = f_Post;
    }
    public facultymodel()
    {

    }

    public String getF_Email() {
        return F_Email;
    }

    public void setF_Email(String f_Email) {
        F_Email = f_Email;
    }

    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public String getF_Post() {
        return F_Post;
    }

    public void setF_Post(String f_Post) {
        F_Post = f_Post;
    }
}
