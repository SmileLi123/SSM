package edu.njust.entity;


/**
 * @description
 * @author gy
 **/
public class User {
    private String uname;
    private String password;
    private String phone;
    private String email;
    private String address;

    public User() {
    }

    public User(String name, String password) {
        this.uname = name;
        this.password = password;
    }

    public User(String name, String password, String phone) {
        this.uname = name;
        this.password = password;
        this.phone = phone;
    }

    public User(String name, String password, String phone, String email, String address) {
        this.uname = name;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getaddress() {
        return address;
    }

    public void setaddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
