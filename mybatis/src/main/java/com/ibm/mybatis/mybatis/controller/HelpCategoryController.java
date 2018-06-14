package com.ibm.mybatis.mybatis.controller;


import com.ibm.mybatis.mybatis.common.Code;
import com.ibm.mybatis.mybatis.common.Result;
import com.ibm.mybatis.mybatis.entity.HelpCategory;
import com.ibm.mybatis.mybatis.service.HelpCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelpCategoryController {

    @Autowired
    private HelpCategoryService helpCategoryService;

    @ResponseBody
    public Result category(){
        List<HelpCategory>  list = helpCategoryService.selectList();
        return new Result<>(Code.SUCCESS, list);
    }
}
