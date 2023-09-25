package com.example.knowledge_managing.mapper;

import com.example.knowledge_managing.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Repository
public interface CategoryMapper extends BaseMapper<Category> {
    public List<Category> get_document_statistics(@Param("level1") String level1);

}
