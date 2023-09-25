package com.example.knowledge_managing.service;

import com.example.knowledge_managing.common.DocumentResult;
import com.example.knowledge_managing.entity.Document;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
public interface IDocumentService extends IService<Document> {
    public List<DocumentResult> get_document_with_page_indexs(Integer begin_index,Integer end_index,String keywords, String user_tags);

}
