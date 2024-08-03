package com.business.service.impl;

import com.business.mapper.CommentMapper;
import com.business.service.ICommentService;
import com.business.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 
* ICommentService业务层处理
*
* @author 49436038@qq.com
* @date 2024-06-04 20:08:52
*/
@Service
public class CommentServiceImpl implements ICommentService
{

    @Autowired
    private CommentMapper commentMapper;


    /**
    * 查询列表
    *
    * @param comment 
    * @return 集合
    */
    @Override
    public List<Comment> selectCommentList(Comment comment) {
        return commentMapper.selectCommentList(comment);
    }


    /**
    * 查询
    *
    * @param id 主键
    * @return 
    */
    @Override
    public Comment selectCommentById(Long id) {
        return commentMapper.selectCommentById(id);
    }

    /**
    * 修改
    *
    * @param comment 
    * @return 结果
    */
    @Override
    public Comment updateCommentById(Comment comment) {
        commentMapper.updateCommentById(comment);
        return comment;
    }

    /**
    * 删除信息
    *
    * @param id 主键
    * @return 结果
    */
    @Override
    public int deleteCommentById(Long id) {
        return commentMapper.deleteCommentById(id);
    }

    /**
    * 新增
    *
    * @param comment 
    * @return 结果
    */
    @Override
    public Comment insertComment(Comment comment) {
        commentMapper.insertComment(comment);
        return comment;
    }
}