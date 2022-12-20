package ru.clevertec.model.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class CheckProduct {
    private Long id;
    private Check check;
    private Product product;
    private int amount;
    private BigDecimal price;   // product price
    private BigDecimal totalPrice;  // products price with discount
    private Discount discount;

    private CheckProduct(Builder builder) {
        id = builder.id;
        check = builder.check;
        product = builder.product;
        amount = builder.amount;
        price = builder.price;
        totalPrice = builder.totalPrice;
        discount = builder.discount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckProduct that = (CheckProduct) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public static final class Builder {
        private Long id;
        private Check check;
        private Product product;
        private int amount;
        private BigDecimal price;
        private BigDecimal totalPrice;
        private Discount discount;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder check(Check check) {
            this.check = check;
            return this;
        }

        public Builder product(Product product) {
            this.product = product;
            return this;
        }

        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder totalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder discount(Discount discount) {
            this.discount = discount;
            return this;
        }

        public CheckProduct build() {
            return new CheckProduct(this);
        }
    }
}
