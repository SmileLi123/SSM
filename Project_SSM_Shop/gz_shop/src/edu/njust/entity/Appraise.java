package edu.njust.entity;

import java.sql.Date;

/**
 * @description 评价
 * @author gy
 **/
public class Appraise {
    private int aid;
    private int oid;
    private String uname;
    private String sname;
    private String cname;
    private String grade;//好评，中评，差评
    private String info;

    public Appraise(int aid, int oid, String uname, String sname, String cname, String grade, String info) {
        this.aid = aid;
        this.oid = oid;
        this.uname = uname;
        this.sname = sname;
        this.cname = cname;
        this.grade = grade;
        this.info = info;
    }

    public Appraise(int oid, String uname, String sname, String cname, String grade, String info) {
        this.oid = oid;
        this.uname = uname;
        this.sname = sname;
        this.cname = cname;
        this.grade = grade;
        this.info = info;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
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

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Appraise{" +
                "aid=" + aid +
                ", oid=" + oid +
                ", uid=" + uname +
                ", sname=" + sname +
                ",cname="+cname+
                ", grade=" + grade +
                ", info='" + info + '\'' +
                '}';
    }
}
