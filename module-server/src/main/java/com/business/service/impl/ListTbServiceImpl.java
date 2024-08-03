package com.business.service.impl;

import com.business.mapper.ListTbMapper;
import com.business.service.IListTbService;
import com.business.domain.ListTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* 
* IListTbService业务层处理
*
* @author 49436038@qq.com
* @date 2024-06-04 20:08:52
*/
@Service
public class ListTbServiceImpl implements IListTbService
{

    @Autowired
    private ListTbMapper listTbMapper;


    /**
    * 查询列表
    *
    * @param listTb 
    * @return 集合
    */
    @Override
    public List<ListTb> selectListTbList(ListTb listTb) {
        return listTbMapper.selectListTbList(listTb);
    }


    /**
    * 查询
    *
    * @param id 主键
    * @return 
    */
    @Override
    public ListTb selectListTbById(Long id) {
        return listTbMapper.selectListTbById(id);
    }

    /**
    * 修改
    *
    * @param listTb 
    * @return 结果
    */
    @Override
    public ListTb updateListTbById(ListTb listTb) {
        listTbMapper.updateListTbById(listTb);
        return listTb;
    }

    /**
    * 删除信息
    *
    * @param id 主键
    * @return 结果
    */
    @Override
    public int deleteListTbById(Long id) {
        return listTbMapper.deleteListTbById(id);
    }

    /**
    * 新增
    *
    * @param listTb 
    * @return 结果
    */
    @Override
    public ListTb insertListTb(ListTb listTb) {
        listTbMapper.insertListTb(listTb);
        return listTb;
    }
}