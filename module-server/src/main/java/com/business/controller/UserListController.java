package com.business.controller;

import com.business.service.IUserListService;
import com.business.domain.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
*  userListController
*
* @author 49436038@qq.com
* @date 2024-06-04 20:08:52
*/
@RestController
@RequestMapping("/userList")
@CrossOrigin(origins = "*")
public class UserListController {

    @Autowired(required = false)
    private IUserListService userListService;

    /**
    * 查询列表
    */
    @GetMapping()
    public List<UserList> list(UserList userList){
        return userListService.selectUserListList(userList);
    }

    /**
    * 查询列表
    */
    @PostMapping("/list")
    @ResponseBody
    public List<UserList> postlist(@RequestBody UserList userList){
        return userListService.selectUserListList(userList);
    }

    /**
    * 获取详细信息
    */
    @GetMapping("/{id}")
    public UserList query(@PathVariable(value = "id") Long id){
        return userListService.selectUserListById(id);
    }

    /**
    * 修改
    */
    @PatchMapping("/{id}")
    @ResponseBody
    public UserList edit(@RequestBody UserList userList,@PathVariable(value = "id") Integer id){
        userList.setId(id);
        return userListService.updateUserListById(userList);
    }

    /**
    * 修改
    */
    @PostMapping("/editbyid/{id}")
    @ResponseBody
    public UserList editbyid(@RequestBody UserList userList,@PathVariable(value = "id") Integer id){
        userList.setId(id);
        return userListService.updateUserListById(userList);
    }

    /**
    * 删除
    */
    @DeleteMapping("/{id}")
    public int del(@PathVariable(value = "id") Long id){
        return userListService.deleteUserListById(id);
    }

    /**
    * 新增
    */
    @PostMapping()
    @ResponseBody
    public UserList add(@RequestBody UserList userList){
        return userListService.insertUserList(userList);
    }

}