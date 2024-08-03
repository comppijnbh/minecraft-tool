package com.business.service;

import com.business.domain.Comment;
import java.util.List;

/**
* 
*  commentService接口
*
* @author 49436038@qq.com
* @date 2024-06-04 20:08:52
*/
public interface ICommentService {

    /**
    * 查询列表
    *
    * @param comment 
    * @return 集合
    */
    List<Comment> selectCommentList(Comment comment);

    /**
    * 查询
    *
    * @param id 主键
    * @return 
    */
    Comment selectCommentById(Long id);

    /**
    * 修改
    *
    * @param comment 
    * @return 结果
    */
    Comment updateCommentById(Comment comment);

    /**
    * 删除信息
    *
    * @param id 主键
    * @return 结果
    */
    int deleteCommentById(Long id);

    /**
    * 新增
    *
    * @param comment 
    * @return 结果
    */
    Comment insertComment(Comment comment);
}