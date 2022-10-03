package com.bike.store.model;

import java.io.Serializable;

/**
 * A DTO for the {@link com.bike.store.entity.Candidate} entity
 */
public record CandidateModel(Integer id, String fullName) implements Serializable {
}
