package com.bike.store.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "candidates", schema = "hr", catalog = "master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Candidate {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "fullname")
    private String fullName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        if (!Objects.equals(id, candidate.id)) return false;
        return Objects.equals(fullName, candidate.fullName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        return result;
    }
}
