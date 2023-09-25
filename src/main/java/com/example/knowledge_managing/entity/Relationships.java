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
public class Relationships implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关系名称
     */
    private String relationshipName;

    /**
     * 要素类型1
     */
    private Integer entityType1Id;

    /**
     * 要素类型2
     */
    private Integer entityType2Id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getRelationshipName() {
        return relationshipName;
    }

    public void setRelationshipName(String relationshipName) {
        this.relationshipName = relationshipName;
    }
    public Integer getEntityType1Id() {
        return entityType1Id;
    }

    public void setEntityType1Id(Integer entityType1Id) {
        this.entityType1Id = entityType1Id;
    }
    public Integer getEntityType2Id() {
        return entityType2Id;
    }

    public void setEntityType2Id(Integer entityType2Id) {
        this.entityType2Id = entityType2Id;
    }

    @Override
    public String toString() {
        return "Relationships{" +
            "id=" + id +
            ", relationshipName=" + relationshipName +
            ", entityType1Id=" + entityType1Id +
            ", entityType2Id=" + entityType2Id +
        "}";
    }
}
