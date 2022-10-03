package com.bike.store.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "sales", catalog = "master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private Integer orderId;
    @Basic
    @Column(name = "order_status")
    private byte orderStatus;
    @Basic
    @Column(name = "order_date")
    private Date orderDate;
    @Basic
    @Column(name = "required_date")
    private Date requiredDate;
    @Basic
    @Column(name = "shipped_date")
    private Date shippedDate;

    @OneToMany()
    private Collection<OrderItem> orderItems;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    private Store store;
    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    private Staff staff;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        if (!Objects.equals(orderId, order.orderId)) return false;
        if (orderStatus != order.orderStatus) return false;
        if (!Objects.equals(orderDate, order.orderDate)) return false;
        if (!Objects.equals(requiredDate, order.requiredDate)) return false;
        return Objects.equals(shippedDate, order.shippedDate);
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (int) orderStatus;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (requiredDate != null ? requiredDate.hashCode() : 0);
        result = 31 * result + (shippedDate != null ? shippedDate.hashCode() : 0);
        return result;
    }
}
