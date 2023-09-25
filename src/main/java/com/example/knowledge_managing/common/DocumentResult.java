package com.example.knowledge_managing.common;

import lombok.Data;

@Data
public class DocumentResult {
    private Integer index;

    private Integer id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 所属数据集
     */
    private Integer datasetId;

    /**
     * 物理存储位置
     */
    private String storageUrl;

    /**
     * 用户定义标签信息（以文档目录形式呈现）
     */
    private String userTags;

    /**
     * 基于文档内容的关键词（智能抽取）
     */
    private String keyList;

    /**
     * 摘要信息或内容前20行
     */
    private String introduction;

    /**
     * 用户点击次数
     */
    private Integer pv;
}
