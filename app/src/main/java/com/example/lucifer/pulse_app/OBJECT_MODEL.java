package com.example.lucifer.pulse_app;

public class OBJECT_MODEL {
    private String category, pname, pimage, pid, mrp;


    public OBJECT_MODEL(String pid, String category, String pname, String pimage, String mrp) {
        this.pid = pid;
        this.category = category;
        this.pname = pname;
        this.pimage = pimage;
        this.mrp = mrp;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }
}
