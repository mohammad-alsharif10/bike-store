package com.bike.store.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "order_items", schema = "sales", catalog = "master")
@IdClass(OrderItemPK.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private Integer orderId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "item_id")
    private Integer itemId;
    @Basic
    @Column(name = "product_id")
    private Integer productId;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "list_price")
    private BigDecimal listPrice;
    @Basic
    @Column(name = "discount")
    private BigDecimal discount;
//    @ManyToOne
//    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
//    private Order order;
//    @ManyToOne
//    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
//    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        if (!Objects.equals(orderId, orderItem.orderId)) return false;
        if (!Objects.equals(itemId, orderItem.itemId)) return false;
        if (!Objects.equals(productId, orderItem.productId)) return false;
        if (quantity != orderItem.quantity) return false;
        if (!Objects.equals(listPrice, orderItem.listPrice)) return false;
        return Objects.equals(discount, orderItem.discount);
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + itemId;
        result = 31 * result + productId;
        result = 31 * result + quantity;
        result = 31 * result + (listPrice != null ? listPrice.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }
}
