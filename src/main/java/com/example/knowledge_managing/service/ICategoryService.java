package com.example.knowledge_managing.service;

import com.example.knowledge_managing.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.knowledge_managing.entity.TreeStatistics;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
public interface ICategoryService extends IService<Category> {
    public List<TreeStatistics> get_document_statistics(String level1);
}
