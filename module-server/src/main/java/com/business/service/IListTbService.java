package com.business.service;

import com.business.domain.ListTb;
import java.util.List;

/**
* 
*  list_tbService接口
*
* @author 49436038@qq.com
* @date 2024-06-04 20:08:52
*/
public interface IListTbService {

    /**
    * 查询列表
    *
    * @param listTb 
    * @return 集合
    */
    List<ListTb> selectListTbList(ListTb listTb);

    /**
    * 查询
    *
    * @param id 主键
    * @return 
    */
    ListTb selectListTbById(Long id);

    /**
    * 修改
    *
    * @param listTb 
    * @return 结果
    */
    ListTb updateListTbById(ListTb listTb);

    /**
    * 删除信息
    *
    * @param id 主键
    * @return 结果
    */
    int deleteListTbById(Long id);

    /**
    * 新增
    *
    * @param listTb 
    * @return 结果
    */
    ListTb insertListTb(ListTb listTb);
}