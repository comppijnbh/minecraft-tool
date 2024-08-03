package com.business.controller;

import com.business.service.IListTbService;
import com.business.domain.ListTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
*  listTbController
*
* @author 49436038@qq.com
* @date 2024-06-04 20:08:52
*/
@RestController
@RequestMapping("/list")
@CrossOrigin(origins = "*")
public class ListTbController {

    @Autowired(required = false)
    private IListTbService listTbService;

    /**
    * 查询列表
    */
    @GetMapping()
    public List<ListTb> list(ListTb listTb){
        return listTbService.selectListTbList(listTb);
    }

    /**
    * 查询列表
    */
    @PostMapping("/list")
    @ResponseBody
    public List<ListTb> postlist(@RequestBody ListTb listTb){
        return listTbService.selectListTbList(listTb);
    }

    /**
    * 获取详细信息
    */
    @GetMapping("/{id}")
    public ListTb query(@PathVariable(value = "id") Long id){
        return listTbService.selectListTbById(id);
    }

    /**
    * 修改
    */
    @PatchMapping("/{id}")
    @ResponseBody
    public ListTb edit(@RequestBody ListTb listTb,@PathVariable(value = "id") Integer id){
        listTb.setId(id);
        return listTbService.updateListTbById(listTb);
    }

    /**
    * 修改
    */
    @PostMapping("/editbyid/{id}")
    @ResponseBody
    public ListTb editbyid(@RequestBody ListTb listTb,@PathVariable(value = "id") Integer id){
        listTb.setId(id);
        return listTbService.updateListTbById(listTb);
    }

    /**
    * 删除
    */
    @DeleteMapping("/{id}")
    public int del(@PathVariable(value = "id") Long id){
        return listTbService.deleteListTbById(id);
    }

    /**
    * 新增
    */
    @PostMapping()
    @ResponseBody
    public ListTb add(@RequestBody ListTb listTb){
        return listTbService.insertListTb(listTb);
    }

}