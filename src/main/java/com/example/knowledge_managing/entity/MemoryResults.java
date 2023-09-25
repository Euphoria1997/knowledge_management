package com.example.knowledge_managing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
@TableName("memory_results")
public class MemoryResults implements Serializable {

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
     * 用户定义类别（标签集合,逗号隔开）	文件类型、文档涉及的产品类别、来源于生产系统的要素信息等
     */
    private String userTags;

    /**
     * 用户定义类别（根据用户定义分类规范F分层）
     */
    private String level1;

    /**
     * 用户定义类别（根据用户定义分类规范F分层）
     */
    private String level2;

    /**
     * 用户定义类别（根据用户定义分类规范F分层）
     */
    private String level3;

    /**
     * 用户定义类别（根据用户定义分类规范F分层）
     */
    private String level4;

    /**
     * 摘要信息或内容前20行
     */
    private String introduction;

    /**
     * 用户点击次数
     */
    private Integer pv;

    /**
     * 大模型语义向量
     */
    private Double semanticCode;

    /**
     * 哈希码
     */
    private String hashCode;

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
    public String getUserTags() {
        return userTags;
    }

    public void setUserTags(String userTags) {
        this.userTags = userTags;
    }
    public String getLevel1() {
        return level1;
    }

    public void setLevel1(String level1) {
        this.level1 = level1;
    }
    public String getLevel2() {
        return level2;
    }

    public void setLevel2(String level2) {
        this.level2 = level2;
    }
    public String getLevel3() {
        return level3;
    }

    public void setLevel3(String level3) {
        this.level3 = level3;
    }
    public String getLevel4() {
        return level4;
    }

    public void setLevel4(String level4) {
        this.level4 = level4;
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
    public Double getSemanticCode() {
        return semanticCode;
    }

    public void setSemanticCode(Double semanticCode) {
        this.semanticCode = semanticCode;
    }
    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    @Override
    public String toString() {
        return "MemoryResults{" +
            "id=" + id +
            ", name=" + name +
            ", datasetId=" + datasetId +
            ", userTags=" + userTags +
            ", level1=" + level1 +
            ", level2=" + level2 +
            ", level3=" + level3 +
            ", level4=" + level4 +
            ", introduction=" + introduction +
            ", pv=" + pv +
            ", semanticCode=" + semanticCode +
            ", hashCode=" + hashCode +
        "}";
    }
}
