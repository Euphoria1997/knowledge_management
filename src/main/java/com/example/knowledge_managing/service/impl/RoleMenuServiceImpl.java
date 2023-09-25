package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.RoleMenu;
import com.example.knowledge_managing.mapper.RoleMenuMapper;
import com.example.knowledge_managing.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

}
