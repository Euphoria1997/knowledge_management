package com.example.knowledge_managing.common;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class QueryInfo implements Serializable {
    // 查询筛选条件
    private String keyword;
    private List<String> user_tags;
    //  时间区间
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    // 页面信息
    private Integer pageIndex;
    private Integer pageSize;
    // 用户信息使用cookie获取token
    private String userID;

    // 查询初始设置
    // 缓存页数
    private Integer cache_page = 10;
//    todo: 用户角色标识符（层次化权限字典：管理员，普通用户，注册用户。。。预留)
//    todo: 页面交互（统计、云图、chat）后需要传输的信息（分块）
}
