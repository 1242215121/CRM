package com.study.model.pojo.product;

import javax.persistence.*;
import java.util.Objects;

public class TypeEntity {
    private int typeId;
    private String typeName;
    private Integer parentId;

    public TypeEntity() {
        super();
    }

    public TypeEntity(int typeId, String typeName, Integer parentId) {
        this.typeId = typeId;
        this.typeName = typeName;
        this.parentId = parentId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "TypeEntity{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", parentId=" + parentId +
                '}';
    }
}
