package com.bike.store.entity;



import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "brands", schema = "production", catalog = "master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "brand_id")
    private Integer brandId;
    @Basic
    @Column(name = "brand_name")
    private String brandName;

    @OneToMany(mappedBy = "brand")
    private Collection<Product> products;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        if (!Objects.equals(brandId, brand.brandId)) return false;
        return Objects.equals(brandName, brand.brandName);
    }

    @Override
    public int hashCode() {
        int result = brandId;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        return result;
    }
}
