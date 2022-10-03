package com.bike.store.model;

import com.bike.store.entity.Staff;

import java.io.Serializable;
import java.util.Collection;

/**
 * A DTO for the {@link com.bike.store.entity.Staff} entity
 */
public record StaffModel(Integer staffId, String firstName, String lastName, String email, String phone, byte active,
                         Collection<OrderModel> orders, StoreModel store, StaffModel manager,
                         Collection<StaffModel> staffCollection) implements Serializable {
}
