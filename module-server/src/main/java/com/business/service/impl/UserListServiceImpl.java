package com.business.service.impl;

import com.business.mapper.UserListMapper;
import com.business.service.IUserListService;
import com.business.domain.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 
* IUserListService业务层处理
*
* @author 49436038@qq.com
* @date 2024-06-04 20:08:52
*/
@Service
public class UserListServiceImpl implements IUserListService
{

    @Autowired
    private UserListMapper userListMapper;


    /**
    * 查询列表
    *
    * @param userList 
    * @return 集合
    */
    @Override
    public List<UserList> selectUserListList(UserList userList) {
        return userListMapper.selectUserListList(userList);
    }


    /**
    * 查询
    *
    * @param id 主键
    * @return 
    */
    @Override
    public UserList selectUserListById(Long id) {
        return userListMapper.selectUserListById(id);
    }

    /**
    * 修改
    *
    * @param userList 
    * @return 结果
    */
    @Override
    public UserList updateUserListById(UserList userList) {
        userListMapper.updateUserListById(userList);
        return userList;
    }

    /**
    * 删除信息
    *
    * @param id 主键
    * @return 结果
    */
    @Override
    public int deleteUserListById(Long id) {
        return userListMapper.deleteUserListById(id);
    }

    /**
    * 新增
    *
    * @param userList 
    * @return 结果
    */
    @Override
    public UserList insertUserList(UserList userList) {
        userListMapper.insertUserList(userList);
        return userList;
    }
}