package edu.njust.entity;

/**
 * Created by gy on 2020/10/1.
 */
public class Scart {
    private int gid;
    private String uname;
    private int cid;
    private String sname;
    private String cname;
    private double price;
    private int num;

    public Scart(int gid, String uname, int cid, String sname, String cname, double price, int num) {
        this.gid = gid;
        this.uname = uname;
        this.cid = cid;
        this.sname = sname;
        this.cname = cname;
        this.price = price;
        this.num = num;
    }

    public Scart(String uname, int cid, String sname, String cname, double price, int num) {
        this.uname = uname;
        this.cid = cid;
        this.sname = sname;
        this.cname = cname;
        this.price = price;
        this.num = num;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Scart(int cid) {
        this.cid = cid;
    }

    public Scart(String uname) {
        this.uname = uname;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Scart{" +
                "gid=" + gid +
                ", uname=" + uname +
                ", cid=" + cid +
                ", sname=" + sname +
                ", cname=" + cname +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}