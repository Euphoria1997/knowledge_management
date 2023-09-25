package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.Role;
import com.example.knowledge_managing.mapper.RoleMapper;
import com.example.knowledge_managing.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
