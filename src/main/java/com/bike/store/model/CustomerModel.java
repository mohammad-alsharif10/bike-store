package com.bike.store.model;

import java.io.Serializable;
import java.util.Collection;

/**
 * A DTO for the {@link com.bike.store.entity.Customer} entity
 */
public record CustomerModel(Integer customerId, String firstName, String lastName, String phone, String email,
                            String street, String city, String state, String zipCode,
                            Collection<OrderModel> orders) implements Serializable {
}
