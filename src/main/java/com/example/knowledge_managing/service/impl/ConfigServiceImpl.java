package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.Config;
import com.example.knowledge_managing.mapper.ConfigMapper;
import com.example.knowledge_managing.service.IConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements IConfigService {

}
