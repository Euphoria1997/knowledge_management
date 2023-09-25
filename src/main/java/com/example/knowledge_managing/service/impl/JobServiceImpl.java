package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.Job;
import com.example.knowledge_managing.mapper.JobMapper;
import com.example.knowledge_managing.service.IJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, Job> implements IJobService {

}
