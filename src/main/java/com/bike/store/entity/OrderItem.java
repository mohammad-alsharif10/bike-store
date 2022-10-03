package entity3;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_items", schema = "sales", catalog = "master")
@IdClass(OrderItemPK.class)
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private int orderId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "item_id")
    private int itemId;
    @Basic
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "quantity")
    private int quantity;
    @Basic
    @Column(name = "list_price")
    private BigDecimal listPrice;
    @Basic
    @Column(name = "discount")
    private BigDecimal discount;
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    private Order ordersByOrderId;
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private Product productsByProductId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (orderId != orderItem.orderId) return false;
        if (itemId != orderItem.itemId) return false;
        if (productId != orderItem.productId) return false;
        if (quantity != orderItem.quantity) return false;
        if (listPrice != null ? !listPrice.equals(orderItem.listPrice) : orderItem.listPrice != null) return false;
        if (discount != null ? !discount.equals(orderItem.discount) : orderItem.discount != null) return false;

        return true;
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

    public Order getOrdersByOrderId() {
        return ordersByOrderId;
    }

    public void setOrdersByOrderId(Order ordersByOrderId) {
        this.ordersByOrderId = ordersByOrderId;
    }

    public Product getProductsByProductId() {
        return productsByProductId;
    }

    public void setProductsByProductId(Product productsByProductId) {
        this.productsByProductId = productsByProductId;
    }
}
