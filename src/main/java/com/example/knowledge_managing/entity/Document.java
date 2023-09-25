package com.example.knowledge_managing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@Data
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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

    /**
     * 哈希码
     */
    private String hashCode;

    /**
     * 大模型语义向量或向量数据库link
     */
    private Double semanticCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Integer datasetId) {
        this.datasetId = datasetId;
    }
    public String getStorageUrl() {
        return storageUrl;
    }

    public void setStorageUrl(String storageUrl) {
        this.storageUrl = storageUrl;
    }
    public String getUserTags() {
        return userTags;
    }

    public void setUserTags(String userTags) {
        this.userTags = userTags;
    }
    public String getKeyList() {
        return keyList;
    }

    public void setKeyList(String keyList) {
        this.keyList = keyList;
    }
    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }
    public Integer getPv() {
        return pv;
    }

    public void setPv(Integer pv) {
        this.pv = pv;
    }
    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }
    public Double getSemanticCode() {
        return semanticCode;
    }

    public void setSemanticCode(Double semanticCode) {
        this.semanticCode = semanticCode;
    }

    @Override
    public String toString() {
        return "Document{" +
            "id=" + id +
            ", name=" + name +
            ", datasetId=" + datasetId +
            ", storageUrl=" + storageUrl +
            ", userTags=" + userTags +
            ", keyList=" + keyList +
            ", introduction=" + introduction +
            ", pv=" + pv +
            ", hashCode=" + hashCode +
            ", semanticCode=" + semanticCode +
        "}";
    }
}
