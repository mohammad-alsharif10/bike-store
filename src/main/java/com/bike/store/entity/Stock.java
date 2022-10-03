package com.bike.store.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stocks", schema = "production", catalog = "master")
@IdClass(StockPK.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private Integer storeId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private Integer productId;
    @Basic
    @Column(name = "quantity")
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        if (!Objects.equals(storeId, stock.storeId)) return false;
        if (!Objects.equals(productId, stock.productId)) return false;
        return Objects.equals(quantity, stock.quantity);
    }

    @Override
    public int hashCode() {
        int result = storeId;
        result = 31 * result + productId;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
