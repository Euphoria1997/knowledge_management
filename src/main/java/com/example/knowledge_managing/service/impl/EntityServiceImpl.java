package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.Entity;
import com.example.knowledge_managing.mapper.EntityMapper;
import com.example.knowledge_managing.service.IEntityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class EntityServiceImpl extends ServiceImpl<EntityMapper, Entity> implements IEntityService {

}
