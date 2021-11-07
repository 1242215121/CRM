package com.study.model.pojo.product;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * 产品类别
 */
public class Type {
    private int typeId; //类别编号
    private String typeName; //类别名称
    private Integer parentId; //父级类别

    private List<Type> types;

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Type() {
        super();
    }

    public Type(int typeId, String typeName, Integer parentId) {
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
