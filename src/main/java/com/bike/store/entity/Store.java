package entity3;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "stores", schema = "sales", catalog = "master")
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private int storeId;
    @Basic
    @Column(name = "store_name")
    private String storeName;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "street")
    private String street;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "state")
    private String state;
    @Basic
    @Column(name = "zip_code")
    private String zipCode;
    @OneToMany(mappedBy = "storesByStoreId")
    private Collection<Stock> stocksByStoreId;
    @OneToMany(mappedBy = "storesByStoreId")
    private Collection<Order> ordersByStoreId;
    @OneToMany(mappedBy = "storesByStoreId")
    private Collection<Staff> staffsByStoreId;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Store store = (Store) o;

        if (storeId != store.storeId) return false;
        if (storeName != null ? !storeName.equals(store.storeName) : store.storeName != null) return false;
        if (phone != null ? !phone.equals(store.phone) : store.phone != null) return false;
        if (email != null ? !email.equals(store.email) : store.email != null) return false;
        if (street != null ? !street.equals(store.street) : store.street != null) return false;
        if (city != null ? !city.equals(store.city) : store.city != null) return false;
        if (state != null ? !state.equals(store.state) : store.state != null) return false;
        if (zipCode != null ? !zipCode.equals(store.zipCode) : store.zipCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = storeId;
        result = 31 * result + (storeName != null ? storeName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }

    public Collection<Stock> getStocksByStoreId() {
        return stocksByStoreId;
    }

    public void setStocksByStoreId(Collection<Stock> stocksByStoreId) {
        this.stocksByStoreId = stocksByStoreId;
    }

    public Collection<Order> getOrdersByStoreId() {
        return ordersByStoreId;
    }

    public void setOrdersByStoreId(Collection<Order> ordersByStoreId) {
        this.ordersByStoreId = ordersByStoreId;
    }

    public Collection<Staff> getStaffsByStoreId() {
        return staffsByStoreId;
    }

    public void setStaffsByStoreId(Collection<Staff> staffsByStoreId) {
        this.staffsByStoreId = staffsByStoreId;
    }
}
