package com.ibm.mybatis.mybatis.mapper;

import com.ibm.mybatis.mybatis.entity.HelpCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HelpCategoryMapper {

    List<HelpCategory> selectList();
}
