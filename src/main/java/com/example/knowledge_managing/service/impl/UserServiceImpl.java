package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.User;
import com.example.knowledge_managing.mapper.UserMapper;
import com.example.knowledge_managing.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
