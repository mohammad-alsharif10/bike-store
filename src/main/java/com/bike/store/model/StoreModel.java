package com.bike.store.model;

import com.bike.store.entity.Store;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.validation.constraints.NotBlank;


/**
 * A DTO for the {@link Store} entity
 */
public record StoreModel(Integer storeId, @NotBlank(message = "Name is mandatory") String storeName, String phone,
                         String email, String street, String city, String state, String zipCode,
                         Collection<StockModel> stocks, Collection<OrderModel> orders,
                         Collection<StaffModel> staffCollection) implements Serializable {

}
