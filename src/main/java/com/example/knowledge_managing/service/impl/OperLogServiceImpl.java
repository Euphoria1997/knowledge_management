package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.OperLog;
import com.example.knowledge_managing.mapper.OperLogMapper;
import com.example.knowledge_managing.service.IOperLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class OperLogServiceImpl extends ServiceImpl<OperLogMapper, OperLog> implements IOperLogService {

}
