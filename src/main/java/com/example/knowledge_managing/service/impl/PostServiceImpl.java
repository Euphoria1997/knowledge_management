package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.Post;
import com.example.knowledge_managing.mapper.PostMapper;
import com.example.knowledge_managing.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
