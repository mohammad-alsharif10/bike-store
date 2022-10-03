package com.bike.store.model;

import com.bike.store.entity.Stock;

import java.io.Serializable;

/**
 * A DTO for the {@link Stock} entity
 */
public record StockModel(Integer storeId, Integer productId, Integer quantity) implements Serializable {}
