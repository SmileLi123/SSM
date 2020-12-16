package edu.njust.entity;

/**
 * @description
 * @author gy
 **/
public class Order {
    private int oid;
    private String uname;
    private String hname;//收货人姓名
    private String sname;
    private int cid;
    private String cname;
    private String hphone;
    private String haddress; //收货地址
    private int num;
    private double tprice;
    private String state; //待发货，已发货，已收货,已评价

    public Order(int oid, String uname, String hname, String sname, int cid, String cname, String hphone, String haddress, int num, double tprice, String state) {
        this.oid = oid;
        this.uname = uname;
        this.hname = hname;
        this.sname = sname;
        this.cid = cid;
        this.cname = cname;
        this.hphone = hphone;
        this.haddress = haddress;
        this.num = num;
        this.tprice = tprice;
        this.state = state;
    }

    public Order(String uname, String hname, String sname, int cid, String cname, String hphone, String haddress, int num, double tprice, String state) {
        this.uname = uname;
        this.hname = hname;
        this.sname = sname;
        this.cid = cid;
        this.cname = cname;
        this.hphone = hphone;
        this.haddress = haddress;
        this.num = num;
        this.tprice = tprice;
        this.state = state;
    }

    public Order(int oid, String state) {
        this.oid = oid;
        this.state = state;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getTprice() {
        return tprice;
    }

    public void setTprice(double tprice) {
        this.tprice = tprice;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid=" + oid +
                ", uname=" + uname +
                ", hname=" + hname +
                ", sname=" + sname +
                ", cid=" + cid +
                ", cname=" + cname +
                ", hphone=" + hphone +
                ", haddress=" + haddress +
                ", num=" + num +
                ",tprice="+tprice+
                ", state=" + state +
                '}';
    }
}
