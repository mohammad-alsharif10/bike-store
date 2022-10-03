package com.bike.store.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link com.bike.store.entity.OrderItem} entity
 */
public record OrderItemModel(Integer orderId, Integer itemId, Integer productId, int quantity, BigDecimal listPrice,
                             BigDecimal discount) implements Serializable {
}
