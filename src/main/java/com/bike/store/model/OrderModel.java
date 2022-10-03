package com.bike.store.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * A DTO for the {@link com.bike.store.entity.Order} entity
 */
public record OrderModel(Integer orderId, byte orderStatus, Date orderDate, Date requiredDate, Date shippedDate,
                         Collection<OrderItemModel> orderItems, CustomerModel customer, StoreModel store,
                         StaffModel staff) implements Serializable {
}
