package edu.njust.entity;

/**
 * @description
 * @author gy
 **/
public class Commodity {
    private int cid;
    private String sname;
    private String cname;
    private String caname;
    private double price;
    private String describtion;

    public Commodity() {
    }

    public Commodity(int cid, String sname, String cname, String caname, double price, String describtion) {
        this.cid = cid;
        this.sname = sname;
        this.cname = cname;
        this.caname = caname;
        this.price = price;
        this.describtion = describtion;
    }

    public Commodity(int cid, String cname, String caname, double price, String describtion) {
        this.cid = cid;
        this.cname = cname;
        this.caname = caname;
        this.price = price;
        this.describtion = describtion;
    }

    public Commodity(String sname, String cname, String caname, double price, String describtion) {
        this.sname = sname;
        this.cname = cname;
        this.caname = caname;
        this.price = price;
        this.describtion = describtion;
    }
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCaname() {
        return caname;
    }

    public void setCaname(String caname) {
        this.caname = caname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    @Override
    public String toString() {
        return "Commodity{" +
                "cid=" + cid +
                ", sname=" + sname+
                ", cname='" + cname + '\'' +
                ", caname='" + caname + '\'' +
                ", price=" + price +
                ", describtion='" + describtion + '\'' +
                '}';
    }
}
