package com.business.controller;

import com.business.service.ICommentService;
import com.business.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
*  commentController
*
* @author 49436038@qq.com
* @date 2024-06-04 20:08:52
*/
@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired(required = false)
    private ICommentService commentService;

    /**
    * 查询列表
    */
    @GetMapping()
    public List<Comment> list(Comment comment){
        return commentService.selectCommentList(comment);
    }

    /**
    * 查询列表
    */
    @PostMapping("/list")
    @ResponseBody
    public List<Comment> postlist(@RequestBody Comment comment){
        return commentService.selectCommentList(comment);
    }

    /**
    * 获取详细信息
    */
    @GetMapping("/{id}")
    public Comment query(@PathVariable(value = "id") Long id){
        return commentService.selectCommentById(id);
    }

    /**
    * 修改
    */
    @PatchMapping("/{id}")
    @ResponseBody
    public Comment edit(@RequestBody Comment comment,@PathVariable(value = "id") Integer id){
        comment.setId(id);
        return commentService.updateCommentById(comment);
    }

    /**
    * 修改
    */
    @PostMapping("/editbyid/{id}")
    @ResponseBody
    public Comment editbyid(@RequestBody Comment comment,@PathVariable(value = "id") Integer id){
        comment.setId(id);
        return commentService.updateCommentById(comment);
    }

    /**
    * 删除
    */
    @DeleteMapping("/{id}")
    public int del(@PathVariable(value = "id") Long id){
        return commentService.deleteCommentById(id);
    }

    /**
    * 新增
    */
    @PostMapping()
    @ResponseBody
    public Comment add(@RequestBody Comment comment){
        return commentService.insertComment(comment);
    }

}