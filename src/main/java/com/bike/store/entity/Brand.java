package entity3;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "brands", schema = "production", catalog = "master")
public class Brand {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "brand_id")
    private int brandId;
    @Basic
    @Column(name = "brand_name")
    private String brandName;
    @OneToMany(mappedBy = "brandsByBrandId")
    private Collection<Product> productsByBrandId;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        if (brandId != brand.brandId) return false;
        if (brandName != null ? !brandName.equals(brand.brandName) : brand.brandName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = brandId;
        result = 31 * result + (brandName != null ? brandName.hashCode() : 0);
        return result;
    }

    public Collection<Product> getProductsByBrandId() {
        return productsByBrandId;
    }

    public void setProductsByBrandId(Collection<Product> productsByBrandId) {
        this.productsByBrandId = productsByBrandId;
    }
}
