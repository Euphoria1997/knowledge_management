package com.example.knowledge_managing.mapper;

import com.example.knowledge_managing.common.DocumentResult;
import com.example.knowledge_managing.entity.Document;
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
public interface DocumentMapper extends BaseMapper<Document> {
    public List<DocumentResult> get_document_with_page_indexs(@Param("begin_index") Integer begin_index, @Param("end_index") Integer end_index,
                                                              @Param("keywords") String keywords, @Param("user_tags") String user_tags);
}
