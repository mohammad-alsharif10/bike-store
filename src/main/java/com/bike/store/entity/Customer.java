package com.bike.store.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customers", schema = "sales", catalog = "master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "customer_id")
    private Integer customerId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
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

    @OneToMany(mappedBy = "customer")
    private Collection<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        if (!Objects.equals(customerId, customer.customerId)) return false;
        if (!Objects.equals(firstName, customer.firstName)) return false;
        if (!Objects.equals(lastName, customer.lastName)) return false;
        if (!Objects.equals(phone, customer.phone)) return false;
        if (!Objects.equals(email, customer.email)) return false;
        if (!Objects.equals(street, customer.street)) return false;
        if (!Objects.equals(city, customer.city)) return false;
        if (!Objects.equals(state, customer.state)) return false;
        return Objects.equals(zipCode, customer.zipCode);
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        return result;
    }

}
