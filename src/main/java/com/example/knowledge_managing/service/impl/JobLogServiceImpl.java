package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.JobLog;
import com.example.knowledge_managing.mapper.JobLogMapper;
import com.example.knowledge_managing.service.IJobLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度日志表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class JobLogServiceImpl extends ServiceImpl<JobLogMapper, JobLog> implements IJobLogService {

}
