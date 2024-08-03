package com.business.service;

import com.business.domain.UserList;
import java.util.List;

/**
* 
*  user_listService接口
*
* @author 49436038@qq.com
* @date 2024-06-04 20:08:52
*/
public interface IUserListService {

    /**
    * 查询列表
    *
    * @param userList 
    * @return 集合
    */
    List<UserList> selectUserListList(UserList userList);

    /**
    * 查询
    *
    * @param id 主键
    * @return 
    */
    UserList selectUserListById(Long id);

    /**
    * 修改
    *
    * @param userList 
    * @return 结果
    */
    UserList updateUserListById(UserList userList);

    /**
    * 删除信息
    *
    * @param id 主键
    * @return 结果
    */
    int deleteUserListById(Long id);

    /**
    * 新增
    *
    * @param userList 
    * @return 结果
    */
    UserList insertUserList(UserList userList);
}