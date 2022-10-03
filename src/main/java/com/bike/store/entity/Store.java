package com.bike.store.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

@Entity
@Table(name = "stores", schema = "sales", catalog = "master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "store_id")
    private Integer storeId;
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

    @OneToMany()
    private Collection<Stock> stocks;

    @OneToMany(mappedBy = "store")
    private Collection<Order> orders;

    @OneToMany(mappedBy = "store")
    private Collection<Staff> staffCollection;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Store store = (Store) o;

        if (!Objects.equals(storeId, store.storeId)) return false;
        if (!Objects.equals(storeName, store.storeName)) return false;
        if (!Objects.equals(phone, store.phone)) return false;
        if (!Objects.equals(email, store.email)) return false;
        if (!Objects.equals(street, store.street)) return false;
        if (!Objects.equals(city, store.city)) return false;
        if (!Objects.equals(state, store.state)) return false;
        return Objects.equals(zipCode, store.zipCode);
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
}
