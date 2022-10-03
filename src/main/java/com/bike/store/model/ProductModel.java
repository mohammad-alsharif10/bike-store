package com.bike.store.model;

import com.bike.store.entity.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 * A DTO for the {@link Product} entity
 */
public record ProductModel(Integer productId, String productName, short modelYear, BigDecimal listPrice,
                           BrandModel brand, CategoryModel category, Collection<StockModel> stocks,
                           Collection<OrderItemModel> orderItems) implements Serializable {
}
