package com.bike.store.model;

import java.io.Serializable;
import java.util.Collection;

/**
 * A DTO for the {@link com.bike.store.entity.Category} entity
 */
public record CategoryModel(Integer categoryId, String categoryName,
                            Collection<ProductModel> products) implements Serializable {
}
