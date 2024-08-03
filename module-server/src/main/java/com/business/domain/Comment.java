package com.business.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
* 
* @TableName comment
*/
@Data
public class Comment implements Serializable {

    /**
    * 主键
    * id
    */
    private Integer id;

    /**
    * 
    * list_id
    */
    private String listId;

    /**
    * 
    * username
    */
    private String username;

    /**
    * 
    * text
    */
    private String text;

    /** get and set */
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }
    public String getListId() {
        return listId;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

}
