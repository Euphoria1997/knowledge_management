package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.common.DocumentResult;
import com.example.knowledge_managing.entity.Document;
import com.example.knowledge_managing.mapper.DocumentMapper;
import com.example.knowledge_managing.service.IDocumentService;
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
public class DocumentServiceImpl extends ServiceImpl<DocumentMapper, Document> implements IDocumentService {

    @Autowired
    private DocumentMapper documentMapper;
    @Override
    public List<DocumentResult> get_document_with_page_indexs(Integer begin_index, Integer end_index, String keywords, String user_tags) {
        return documentMapper.get_document_with_page_indexs(begin_index,end_index,keywords,user_tags);
    }
}
