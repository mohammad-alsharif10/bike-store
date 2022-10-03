package com.bike.store.model;

import java.io.Serializable;
import java.util.Collection;

/**
 * A DTO for the {@link com.bike.store.entity.Brand} entity
 */
public record BrandModel(Integer brandId, String brandName, Collection<ProductModel> products) implements Serializable {
}
