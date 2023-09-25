package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.Menu;
import com.example.knowledge_managing.mapper.MenuMapper;
import com.example.knowledge_managing.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
