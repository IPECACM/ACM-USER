package com.example.acm;

public class studentmodel {

    String Choice0,Choice1,Choice2;

    public studentmodel(String choice0, String choice1, String choice2) {
        Choice0 = choice0;
        Choice1 = choice1;
        Choice2 = choice2;
    }

    public String getChoice0() {
        return Choice0;
    }

    public void setChoice0(String choice0) {
        Choice0 = choice0;
    }

    public String getChoice1() {
        return Choice1;
    }

    public void setChoice1(String choice1) {
        Choice1 = choice1;
    }

    public String getChoice2() {
        return Choice2;
    }

    public void setChoice2(String choice2) {
        Choice2 = choice2;
    }
}
