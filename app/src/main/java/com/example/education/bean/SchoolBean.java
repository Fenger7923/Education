package com.example.education.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @author fengerzhang
 * @date 2023/12/5 16:51
 */
@Entity
public class SchoolBean {
    @Id(autoincrement = true) //自增id 从1 开始
    private Long schoolId;
    private String schoolName;

    @Keep
    public SchoolBean(String schoolName) {
        this.schoolName = schoolName;
    }

    @Generated(hash = 2040299565)
    public SchoolBean() {
    }

    @Generated(hash = 42248819)
    public SchoolBean(Long schoolId, String schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }

    public Long getSchoolId() {
        return this.schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return this.schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
