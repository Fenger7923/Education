package com.example.education.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * @author fengerzhang
 * @date 2023/12/5 16:20
 */
@Entity
public class StudentBean {
    @Id  //主键
    private Long sId; // 学生身份证号，用于作为唯一ID
    private String sName; // 学生姓名
    private int sGrade; // 学生学级（例如2015年入学则为2015级）
    private boolean sGender; // 学生性别 （false - 女， true - 男）
    private int sClass; // 学生班级

    private Long schoolId; // 所在学校id

    // 例： 张三，身份证号：360123233323231345， 2015级3班，男， 第一中学
    // private StudentBean s = new StudentBean(360123233323231345L, "张三", 2015, true, 3, 1);

    @Keep
    public StudentBean(String sName, Long sId, boolean sGender, int sGrade, int sClass, Long schoolId) {
        this.sId = sId;
        this.sName = sName;
        this.sGrade = sGrade;
        this.sGender = sGender;
        this.sClass = sClass;
        this.schoolId = schoolId;
    }

    @Generated(hash = 2097171990)
    public StudentBean() {
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsGrade() {
        return sGrade;
    }

    public void setsGrade(int sGrade) {
        this.sGrade = sGrade;
    }

    public boolean issGender() {
        return sGender;
    }

    public void setsGender(boolean sGender) {
        this.sGender = sGender;
    }

    public int getsClass() {
        return sClass;
    }

    public void setsClass(int sClass) {
        this.sClass = sClass;
    }

    public Long getSId() {
        return this.sId;
    }

    public void setSId(Long sId) {
        this.sId = sId;
    }

    public String getSName() {
        return this.sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public int getSGrade() {
        return this.sGrade;
    }

    public void setSGrade(int sGrade) {
        this.sGrade = sGrade;
    }

    public boolean getSGender() {
        return this.sGender;
    }

    public void setSGender(boolean sGender) {
        this.sGender = sGender;
    }

    public int getSClass() {
        return this.sClass;
    }

    public void setSClass(int sClass) {
        this.sClass = sClass;
    }

    public Long getSchoolId() {
        return this.schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }
}
