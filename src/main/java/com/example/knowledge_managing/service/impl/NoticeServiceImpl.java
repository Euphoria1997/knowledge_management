package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.Notice;
import com.example.knowledge_managing.mapper.NoticeMapper;
import com.example.knowledge_managing.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知公告表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

}
