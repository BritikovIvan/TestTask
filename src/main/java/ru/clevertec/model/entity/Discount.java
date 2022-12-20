package ru.clevertec.model.entity;

import java.util.Objects;

public class Discount {
    private Long id;
    private int discountQuantity;
    private int discount;

    private Discount(Builder builder) {
        setId(builder.id);
        setDiscountQuantity(builder.discountQuantity);
        setDiscount(builder.discount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDiscountQuantity() {
        return discountQuantity;
    }

    public void setDiscountQuantity(int discountQuantity) {
        this.discountQuantity = discountQuantity;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discount discount = (Discount) o;

        return Objects.equals(id, discount.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public static final class Builder {
        private Long id;
        private int discountQuantity;
        private int discount;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder discountQuantity(int discountQuantity) {
            this.discountQuantity = discountQuantity;
            return this;
        }

        public Builder discount(int discount) {
            this.discount = discount;
            return this;
        }

        public Discount build() {
            return new Discount(this);
        }
    }
}
