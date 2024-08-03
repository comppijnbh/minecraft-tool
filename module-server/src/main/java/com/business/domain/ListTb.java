package com.business.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* 
* @TableName list_tb
*/
@Data
public class ListTb implements Serializable {

    /**
    * 主键
    * id
    */
    private Integer id;

    /**
    * 
    * img
    */
    private String img;

    /**
    * 
    * name
    */
    private String name;

    /**
    * 
    * text
    */
    private String text;

    /**
    * 
    * time
    */
    private String time;

    /** get and set */
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setImg(String img) {
        this.img = img;
    }
    public String getImg() {
        return img;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }

}
