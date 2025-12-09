package com.journalsystem.springprogram.pojo;


public class Student {
    private String sno;
    private  String sname;
    private  String ssex;
    private  String sbirth;
    private String fav;
    private String photoPath;

    public Student() {
    }

    public Student(String sno, String sname, String ssex, String sbirth, String fav, String photoPath) {
        this.sno = sno;
        this.sname = sname;
        this.ssex = ssex;
        this.sbirth = sbirth;
        this.fav = fav;
        this.photoPath = photoPath;
    }

    /**
     * 获取
     * @return sno
     */
    public String getSno() {
        return sno;
    }

    /**
     * 设置
     * @param sno
     */
    public void setSno(String sno) {
        this.sno = sno;
    }

    /**
     * 获取
     * @return sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * 设置
     * @param sname
     */
    public void setSname(String sname) {
        this.sname = sname;
    }

    /**
     * 获取
     * @return ssex
     */
    public String getSsex() {
        return ssex;
    }

    /**
     * 设置
     * @param ssex
     */
    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    /**
     * 获取
     * @return sbirth
     */
    public String getSbirth() {
        return sbirth;
    }

    /**
     * 设置
     * @param sbirth
     */
    public void setSbirth(String sbirth) {
        this.sbirth = sbirth;
    }

    /**
     * 获取
     * @return fav
     */
    public String getFav() {
        return fav;
    }

    /**
     * 设置
     * @param fav
     */
    public void setFav(String fav) {
        this.fav = fav;
    }

    /**
     * 获取
     * @return photoPath
     */
    public String getPhotoPath() {
        return photoPath;
    }

    /**
     * 设置
     * @param photoPath
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String toString() {
        return "Student{sno = " + sno + ", sname = " + sname + ", ssex = " + ssex + ", sbirth = " + sbirth + ", fav = " + fav + ", photoPath = " + photoPath + "}";
    }
}
