package com.company.cubadbviews.web.screens.orderwithproducts;

import com.company.cubadbviews.entity.OrderWithProducts;
import com.company.cubadbviews.entity.Product;
import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.data.GroupDatasource;

import javax.inject.Inject;
import java.util.UUID;

public class OrderWithProductsBrowse extends AbstractLookup {

    @Inject
    protected LookupField productFilterField;

    @Inject
    protected GroupDatasource<OrderWithProducts, UUID> orderWithProductsesDs;

    public void onSearch() {
        orderWithProductsesDs.refresh();
    }
}