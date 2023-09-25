package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.UserRole;
import com.example.knowledge_managing.mapper.UserRoleMapper;
import com.example.knowledge_managing.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
