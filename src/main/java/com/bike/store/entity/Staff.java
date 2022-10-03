package com.bike.store.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "staffs", schema = "sales", catalog = "master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Staff {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "staff_id")
    private Integer staffId;
    @Basic
    @Column(name = "first_name")
    private String firstName;
    @Basic
    @Column(name = "last_name")
    private String lastName;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "active")
    private byte active;

    @OneToMany(mappedBy = "staff")
    private Collection<Order> orders;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    private Store store;
    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "staff_id")
    private Staff manager;

    @OneToMany(mappedBy = "manager")
    private Collection<Staff> staffCollection;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        if (!Objects.equals(staffId, staff.staffId)) return false;
        if (active != staff.active) return false;
        if (!Objects.equals(firstName, staff.firstName)) return false;
        if (!Objects.equals(lastName, staff.lastName)) return false;
        if (!Objects.equals(email, staff.email)) return false;
        return Objects.equals(phone, staff.phone);
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (int) active;
        return result;
    }
}
