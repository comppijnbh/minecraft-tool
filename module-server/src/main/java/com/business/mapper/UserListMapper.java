package com.business.mapper;

import com.business.domain.UserList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 49436038@qq.com
* @description 针对表【user_list】的数据库操作Mapper
* @createDate 2024-06-04 20:08:52
* @Entity com.business.domain.UserList
*/
@Mapper
public interface UserListMapper {

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
    int insertUserList(UserList userList);

    /**
    * 修改
    *
    * @param userList 
    * @return 结果
    */
    int updateUserListById(UserList userList);

    /**
    * 查询列表
    *
    * @param userList 
    * @return user_list集合
    */
    List<UserList> selectUserListList (UserList userList);

    /**
    * 查询
    *
    * @param id 主键
    * @return user_list
    */
    UserList selectUserListById(Long id);
}
