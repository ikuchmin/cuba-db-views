package com.company.cubadbviews.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.DesignSupport;
import org.eclipse.persistence.annotations.Array;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@DesignSupport("{'dbView':true,'generateDdl':false}")
@Table(name = "CUBADBVIEWS_ORDER_WITH_PRODUCTS")
@Entity(name = "cubadbviews$OrderWithProducts")
public class OrderWithProducts extends StandardEntity {
    private static final long serialVersionUID = - 8985822274732427675L;

    @Column(name = "CUSTOMER")
    protected String customer;

    @Column(name = "PRODUCT_IDS")
    protected String productIds;

    @Column(name = "PRODUCTS")
    protected String products;

    public String getProductIds() {
        return productIds;
    }

    public void setProductIds(String productIds) {
        this.productIds = productIds;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}