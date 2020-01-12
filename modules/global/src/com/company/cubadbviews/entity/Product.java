package com.company.cubadbviews.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|name")
@Table(name = "CUBADBVIEWS_PRODUCT")
@Entity(name = "cubadbviews$Product")
public class Product extends StandardEntity {
    private static final long serialVersionUID = 6987145324405816932L;

    @Column(name = "NAME")
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}