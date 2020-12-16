package edu.njust.entity;

/**
 * @description
 * @author gy
 **/
public class Shop {
    private String sname;
    private String password;
    private String sphone;
    private String describtion;


    public Shop() {
    }

    public Shop(String sname, String password) {
        this.sname = sname;
        this.password = password;
    }

    public Shop(String sname, String password,String sphone, String describtion) {
        this.sname = sname;
        this.sphone = sphone;
        this.describtion = describtion;
        this.password = password;
    }


    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getdescribtion() {
        return describtion;
    }

    public void setdescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "sname='" + sname + '\'' +
                ", sphone='" + sphone + '\'' +
                ", describtion='" + describtion + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
