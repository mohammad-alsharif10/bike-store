package entity3;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "staffs", schema = "sales", catalog = "master")
public class Staff {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "staff_id")
    private int staffId;
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
    @Basic
    @Column(name = "store_id")
    private int storeId;
    @Basic
    @Column(name = "manager_id")
    private Integer managerId;
    @OneToMany(mappedBy = "staffsByStaffId")
    private Collection<Order> ordersByStaffId;
    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id", nullable = false)
    private Store storesByStoreId;
    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "staff_id")
    private Staff staffsByManagerId;
    @OneToMany(mappedBy = "staffsByManagerId")
    private Collection<Staff> staffsByStaffId;

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public byte getActive() {
        return active;
    }

    public void setActive(byte active) {
        this.active = active;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (staffId != staff.staffId) return false;
        if (active != staff.active) return false;
        if (storeId != staff.storeId) return false;
        if (firstName != null ? !firstName.equals(staff.firstName) : staff.firstName != null) return false;
        if (lastName != null ? !lastName.equals(staff.lastName) : staff.lastName != null) return false;
        if (email != null ? !email.equals(staff.email) : staff.email != null) return false;
        if (phone != null ? !phone.equals(staff.phone) : staff.phone != null) return false;
        if (managerId != null ? !managerId.equals(staff.managerId) : staff.managerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (int) active;
        result = 31 * result + storeId;
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        return result;
    }

    public Collection<Order> getOrdersByStaffId() {
        return ordersByStaffId;
    }

    public void setOrdersByStaffId(Collection<Order> ordersByStaffId) {
        this.ordersByStaffId = ordersByStaffId;
    }

    public Store getStoresByStoreId() {
        return storesByStoreId;
    }

    public void setStoresByStoreId(Store storesByStoreId) {
        this.storesByStoreId = storesByStoreId;
    }

    public Staff getStaffsByManagerId() {
        return staffsByManagerId;
    }

    public void setStaffsByManagerId(Staff staffsByManagerId) {
        this.staffsByManagerId = staffsByManagerId;
    }

    public Collection<Staff> getStaffsByStaffId() {
        return staffsByStaffId;
    }

    public void setStaffsByStaffId(Collection<Staff> staffsByStaffId) {
        this.staffsByStaffId = staffsByStaffId;
    }
}
