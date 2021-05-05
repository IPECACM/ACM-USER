package com.example.acm;

public class choicemodel {
    String Name, pdfUrl;

    choicemodel()
    {

    }

    public choicemodel(String name, String pdfUrl) {
        Name = name;
        this.pdfUrl = pdfUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
