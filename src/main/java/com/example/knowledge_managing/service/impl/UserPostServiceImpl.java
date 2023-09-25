package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.UserPost;
import com.example.knowledge_managing.mapper.UserPostMapper;
import com.example.knowledge_managing.service.IUserPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class UserPostServiceImpl extends ServiceImpl<UserPostMapper, UserPost> implements IUserPostService {

}
