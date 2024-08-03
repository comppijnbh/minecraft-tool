package com.business.mapper;

import com.business.domain.ListTb;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 49436038@qq.com
* @description 针对表【list_tb】的数据库操作Mapper
* @createDate 2024-06-04 20:08:52
* @Entity com.business.domain.ListTb
*/
@Mapper
public interface ListTbMapper {

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
    int insertListTb(ListTb listTb);

    /**
    * 修改
    *
    * @param listTb 
    * @return 结果
    */
    int updateListTbById(ListTb listTb);

    /**
    * 查询列表
    *
    * @param listTb 
    * @return list_tb集合
    */
    List<ListTb> selectListTbList (ListTb listTb);

    /**
    * 查询
    *
    * @param id 主键
    * @return list_tb
    */
    ListTb selectListTbById(Long id);
}
