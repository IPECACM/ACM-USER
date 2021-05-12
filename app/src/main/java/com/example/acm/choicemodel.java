package com.example.acm;

public class choicemodel {
    String Name, pdfUrl,SIG;

    choicemodel()
    {

    }

    public String getSIG() {
        return SIG;
    }

    public void setSIG(String SIG) {
        this.SIG = SIG;
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
