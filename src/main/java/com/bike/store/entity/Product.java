package com.bike.store.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "production", catalog = "master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private Integer productId;
    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "model_year")
    private short modelYear;
    @Basic
    @Column(name = "list_price")
    private BigDecimal listPrice;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id", nullable = false)
    private Brand brand;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category category;

    @OneToMany()
    private Collection<Stock> stocks;

    @OneToMany()
    private Collection<OrderItem> orderItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        if (!Objects.equals(productId, product.productId)) return false;
        if (modelYear != product.modelYear) return false;
        if (!Objects.equals(productName, product.productName)) return false;
        return Objects.equals(listPrice, product.listPrice);
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (int) modelYear;
        result = 31 * result + (listPrice != null ? listPrice.hashCode() : 0);
        return result;
    }
}
