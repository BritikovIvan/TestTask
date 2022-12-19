package ru.clevertec.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Check {
    private Long id;
    private List<CheckProduct> products;
    private DiscountCard card;
    private BigDecimal totalPrice;
    private BigDecimal discountPrice;
    private LocalDateTime dateTime;

    private Check(Builder builder) {
        id = builder.id;
        products = builder.products;
        card = builder.card;
        totalPrice = builder.totalPrice;
        discountPrice = builder.discountPrice;
        dateTime = builder.dateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CheckProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CheckProduct> products) {
        this.products = products;
    }

    public DiscountCard getCard() {
        return card;
    }

    public void setCard(DiscountCard card) {
        this.card = card;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Check check = (Check) o;

        return Objects.equals(id, check.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public static final class Builder {
        private Long id;
        private List<CheckProduct> products;
        private DiscountCard card;
        private BigDecimal totalPrice;
        private BigDecimal discountPrice;
        private LocalDateTime dateTime;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder products(List<CheckProduct> products) {
            this.products = products;
            return this;
        }

        public Builder card(DiscountCard card) {
            this.card = card;
            return this;
        }

        public Builder totalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder discountPrice(BigDecimal discountPrice) {
            this.discountPrice = discountPrice;
            return this;
        }

        public Builder dateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Check build() {
            return new Check(this);
        }
    }
}
