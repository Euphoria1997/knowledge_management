package com.example.knowledge_managing.entity;

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
@TableName("entity_attribute")
public class EntityAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 要素id
     */
    private Integer entityId;

    /**
     * 要素属性名称
     */
    private String attributeName;

    /**
     * 要素属性值
     */
    private String attributeValue;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getEntityId() {
        return entityId;
    }

    public void setEntityId(Integer entityId) {
        this.entityId = entityId;
    }
    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    @Override
    public String toString() {
        return "EntityAttribute{" +
            "id=" + id +
            ", entityId=" + entityId +
            ", attributeName=" + attributeName +
            ", attributeValue=" + attributeValue +
        "}";
    }
}
