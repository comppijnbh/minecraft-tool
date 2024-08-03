package com.business.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* 
* @TableName user_list
*/
@Data
public class UserList implements Serializable {

    /**
    * 主键
    * id
    */
    private Integer id;

    /**
    * 
    * username
    */
    private String username;

    /**
    * 
    * password
    */
    private String password;

    /**
    * 
    * name
    */
    private String name;

    /**
    * 
    * age
    */
    private String age;

    /**
    * 
    * sex
    */
    private String sex;

    /**
    * 
    * tel
    */
    private String tel;

    /**
    * 
    * state
    */
    private String state;

    /**
    * 
    * teacher
    */
    private String teacher;

    /**
    * 
    * limit
    */
    private String limit;

    /**
    * 
    * year
    */
    private String year;

    /**
    * 
    * clas
    */
    private String clas;

    /**
    * 
    * enterprise
    */
    private String enterprise;

    /** get and set */
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getAge() {
        return age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getSex() {
        return sex;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getTel() {
        return tel;
    }

    public void setState(String state) {
        this.state = state;
    }
    public String getState() {
        return state;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    public String getTeacher() {
        return teacher;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
    public String getLimit() {
        return limit;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getYear() {
        return year;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }
    public String getClas() {
        return clas;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise;
    }
    public String getEnterprise() {
        return enterprise;
    }

}
