package com.example.restaurant_mobile_app;



public class Booking {
    private int id;
    private String tname ,name, nic, date, time;


    public Booking() {

    }

    public Booking(int id,String tname, String name, String nic, String date, String time) {
        this.id = id;
        this.tname = tname;
        this.name = name;
        this.nic = nic;
        this.date = date;
        this.time = time;
    }

    public Booking(String tname, String name, String nic, String date, String time) {
        this.tname = tname;
        this.name = name;
        this.nic = nic;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String content) {
        this.time = time;
    }


}
