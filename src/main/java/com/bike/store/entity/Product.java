package entity3;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "products", schema = "production", catalog = "master")
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "product_id")
    private int productId;
    @Basic
    @Column(name = "product_name")
    private String productName;
    @Basic
    @Column(name = "brand_id")
    private int brandId;
    @Basic
    @Column(name = "category_id")
    private int categoryId;
    @Basic
    @Column(name = "model_year")
    private short modelYear;
    @Basic
    @Column(name = "list_price")
    private BigDecimal listPrice;
    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id", nullable = false)
    private Brand brandsByBrandId;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    private Category categoriesByCategoryId;
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<Stock> stocksByProductId;
    @OneToMany(mappedBy = "productsByProductId")
    private Collection<OrderItem> orderItemsByProductId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public short getModelYear() {
        return modelYear;
    }

    public void setModelYear(short modelYear) {
        this.modelYear = modelYear;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != product.productId) return false;
        if (brandId != product.brandId) return false;
        if (categoryId != product.categoryId) return false;
        if (modelYear != product.modelYear) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (listPrice != null ? !listPrice.equals(product.listPrice) : product.listPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productId;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + brandId;
        result = 31 * result + categoryId;
        result = 31 * result + (int) modelYear;
        result = 31 * result + (listPrice != null ? listPrice.hashCode() : 0);
        return result;
    }

    public Brand getBrandsByBrandId() {
        return brandsByBrandId;
    }

    public void setBrandsByBrandId(Brand brandsByBrandId) {
        this.brandsByBrandId = brandsByBrandId;
    }

    public Category getCategoriesByCategoryId() {
        return categoriesByCategoryId;
    }

    public void setCategoriesByCategoryId(Category categoriesByCategoryId) {
        this.categoriesByCategoryId = categoriesByCategoryId;
    }

    public Collection<Stock> getStocksByProductId() {
        return stocksByProductId;
    }

    public void setStocksByProductId(Collection<Stock> stocksByProductId) {
        this.stocksByProductId = stocksByProductId;
    }

    public Collection<OrderItem> getOrderItemsByProductId() {
        return orderItemsByProductId;
    }

    public void setOrderItemsByProductId(Collection<OrderItem> orderItemsByProductId) {
        this.orderItemsByProductId = orderItemsByProductId;
    }
}
