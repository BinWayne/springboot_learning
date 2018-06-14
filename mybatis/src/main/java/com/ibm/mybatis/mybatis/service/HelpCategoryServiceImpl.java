package com.ibm.mybatis.mybatis.service;

import com.ibm.mybatis.mybatis.entity.HelpCategory;
import com.ibm.mybatis.mybatis.mapper.HelpCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpCategoryServiceImpl implements HelpCategoryService{

    @Autowired
    private HelpCategoryMapper helpCategoryMapper;

    @Override
    public List<HelpCategory> selectList() {
        return helpCategoryMapper.selectList();
    }


}
