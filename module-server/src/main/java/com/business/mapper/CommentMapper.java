package com.business.mapper;

import com.business.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 49436038@qq.com
* @description 针对表【comment】的数据库操作Mapper
* @createDate 2024-06-04 20:08:52
* @Entity com.business.domain.Comment
*/
@Mapper
public interface CommentMapper {

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
    int insertComment(Comment comment);

    /**
    * 修改
    *
    * @param comment 
    * @return 结果
    */
    int updateCommentById(Comment comment);

    /**
    * 查询列表
    *
    * @param comment 
    * @return comment集合
    */
    List<Comment> selectCommentList (Comment comment);

    /**
    * 查询
    *
    * @param id 主键
    * @return comment
    */
    Comment selectCommentById(Long id);
}
