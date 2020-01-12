package com.company.cubadbviews.web.screens.order;

import com.company.cubadbviews.entity.Order;
import com.company.cubadbviews.entity.OrderItem;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Table;

import java.util.stream.Collectors;

public class OrderBrowse extends AbstractLookup {

    public Component generateProductsCell(Order entity) {
        String products = entity.getItems().stream()
                .map(OrderItem::getProduct)
                .map(Entity::getInstanceName)
                .collect(Collectors.joining(", "));

        return new Table.PlainTextCell(products);
    }
}