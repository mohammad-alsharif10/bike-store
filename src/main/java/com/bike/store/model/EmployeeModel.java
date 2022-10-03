package com.bike.store.model;

import java.io.Serializable;

/**
 * A DTO for the {@link com.bike.store.entity.Employee} entity
 */
public record EmployeeModel(Integer id, String fullName) implements Serializable {
}
