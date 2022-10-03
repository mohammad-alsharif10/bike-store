package entity3;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "orders", schema = "sales", catalog = "master")
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id")
    private int orderId;
    @Basic
    @Column(name = "customer_id")
    private Integer customerId;
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
    @Basic
    @Column(name = "store_id")
    private int storeId;
    @Basic
    @Column(name = "staff_id")
    private int staffId;
    @OneToMany(mappedBy = "ordersByOrderId")
    private Collection<OrderItem> orderItemsByOrderId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customersByCustomerId;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    private Store storesByStoreId;
    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    private Staff staffsByStaffId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderId != order.orderId) return false;
        if (orderStatus != order.orderStatus) return false;
        if (storeId != order.storeId) return false;
        if (staffId != order.staffId) return false;
        if (customerId != null ? !customerId.equals(order.customerId) : order.customerId != null) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        if (requiredDate != null ? !requiredDate.equals(order.requiredDate) : order.requiredDate != null) return false;
        if (shippedDate != null ? !shippedDate.equals(order.shippedDate) : order.shippedDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (int) orderStatus;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (requiredDate != null ? requiredDate.hashCode() : 0);
        result = 31 * result + (shippedDate != null ? shippedDate.hashCode() : 0);
        result = 31 * result + storeId;
        result = 31 * result + staffId;
        return result;
    }

    public Collection<OrderItem> getOrderItemsByOrderId() {
        return orderItemsByOrderId;
    }

    public void setOrderItemsByOrderId(Collection<OrderItem> orderItemsByOrderId) {
        this.orderItemsByOrderId = orderItemsByOrderId;
    }

    public Customer getCustomersByCustomerId() {
        return customersByCustomerId;
    }

    public void setCustomersByCustomerId(Customer customersByCustomerId) {
        this.customersByCustomerId = customersByCustomerId;
    }

    public Store getStoresByStoreId() {
        return storesByStoreId;
    }

    public void setStoresByStoreId(Store storesByStoreId) {
        this.storesByStoreId = storesByStoreId;
    }

    public Staff getStaffsByStaffId() {
        return staffsByStaffId;
    }

    public void setStaffsByStaffId(Staff staffsByStaffId) {
        this.staffsByStaffId = staffsByStaffId;
    }
}
