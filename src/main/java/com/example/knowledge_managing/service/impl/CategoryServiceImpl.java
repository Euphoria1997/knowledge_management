package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.Category;
import com.example.knowledge_managing.entity.TreeStatistics;
import com.example.knowledge_managing.mapper.CategoryMapper;
import com.example.knowledge_managing.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private  CategoryMapper categoryMapper;
    /**
     * 形成树形结构，前端展示。？？？前端需要的数据结构
    */
    @Override
    public List<TreeStatistics> get_document_statistics(String level1) {
        List<Category> document_statistics = categoryMapper.get_document_statistics(level1);

        return null;
    }
}
