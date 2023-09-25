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
@TableName("original_dataset")
public class OriginalDataset implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 数据集名称
     */
    private String name;

    /**
     * 数据集描述
     */
    private String description;

    /**
     * 物理存储本系统位置
     */
    private String storageUrl;

    /**
     * 存储类型；	1表示：目录	2表示：minio对象存储
     */
    private Boolean storageType;

    /**
     * 数据集状态；	1:发布;	2:未发布，未处理状态
     */
    private Boolean status;

    /**
     * 存储访问参数，包括ak,sk,endpoint
     */
    private String storageParams;

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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getStorageUrl() {
        return storageUrl;
    }

    public void setStorageUrl(String storageUrl) {
        this.storageUrl = storageUrl;
    }
    public Boolean getStorageType() {
        return storageType;
    }

    public void setStorageType(Boolean storageType) {
        this.storageType = storageType;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getStorageParams() {
        return storageParams;
    }

    public void setStorageParams(String storageParams) {
        this.storageParams = storageParams;
    }

    @Override
    public String toString() {
        return "OriginalDataset{" +
            "id=" + id +
            ", name=" + name +
            ", description=" + description +
            ", storageUrl=" + storageUrl +
            ", storageType=" + storageType +
            ", status=" + status +
            ", storageParams=" + storageParams +
        "}";
    }
}
