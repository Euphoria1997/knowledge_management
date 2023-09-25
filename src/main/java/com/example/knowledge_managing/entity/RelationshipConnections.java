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
@TableName("relationship_connections")
public class RelationshipConnections implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 关系定义id
     */
    private Integer relationshipId;

    /**
     * 要素1
     */
    private Integer entity1Id;

    /**
     * 要素2
     */
    private Integer entity2Id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Integer relationshipId) {
        this.relationshipId = relationshipId;
    }
    public Integer getEntity1Id() {
        return entity1Id;
    }

    public void setEntity1Id(Integer entity1Id) {
        this.entity1Id = entity1Id;
    }
    public Integer getEntity2Id() {
        return entity2Id;
    }

    public void setEntity2Id(Integer entity2Id) {
        this.entity2Id = entity2Id;
    }

    @Override
    public String toString() {
        return "RelationshipConnections{" +
            "id=" + id +
            ", relationshipId=" + relationshipId +
            ", entity1Id=" + entity1Id +
            ", entity2Id=" + entity2Id +
        "}";
    }
}
