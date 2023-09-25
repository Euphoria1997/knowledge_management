package com.example.knowledge_managing.service.impl;

import com.example.knowledge_managing.entity.Dept;
import com.example.knowledge_managing.mapper.DeptMapper;
import com.example.knowledge_managing.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
