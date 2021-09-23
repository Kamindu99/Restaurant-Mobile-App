package com.example.restaurant_mobile_app;

public class Pay {
    private String name;
    private Integer mobileno;
    private String amount;
    private Long cardno;
    private String date;
    private Integer cvv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMobileno() {
        return mobileno;
    }

    public void setMobileno(Integer mobileno) {
        this.mobileno = mobileno;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Long getCardno() {
        return cardno;
    }

    public void setCardno(Long cardno) {
        this.cardno = cardno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Pay() {

    }

}
