package com.bike.store.entity;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockPK implements Serializable {
    @Column(name = "store_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeId;
    @Column(name = "product_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockPK stockPK = (StockPK) o;

        if (!Objects.equals(storeId, stockPK.storeId)) return false;
        return Objects.equals(productId, stockPK.productId);
    }

    @Override
    public int hashCode() {
        int result = storeId;
        result = 31 * result + productId;
        return result;
    }
}
