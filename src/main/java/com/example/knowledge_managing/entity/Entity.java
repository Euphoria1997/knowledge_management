package com.example.knowledge_managing.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wenwen
 * @since 2023-09-22
 */
public class Entity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 要素名称
     */
    private String entityName;

    /**
     * 要素类型id
     */
    private Integer entityTypeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }
    public Integer getEntityTypeId() {
        return entityTypeId;
    }

    public void setEntityTypeId(Integer entityTypeId) {
        this.entityTypeId = entityTypeId;
    }

    @Override
    public String toString() {
        return "Entity{" +
            "id=" + id +
            ", entityName=" + entityName +
            ", entityTypeId=" + entityTypeId +
        "}";
    }
}
