package com.ibm.mybatis.mybatis.service;

import com.ibm.mybatis.mybatis.entity.HelpCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HelpCategoryService {
    List<HelpCategory> selectList();
}
