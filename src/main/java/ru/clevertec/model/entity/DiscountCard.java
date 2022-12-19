package ru.clevertec.model.entity;

import java.util.Objects;

public class DiscountCard {
    private Long id;
    private String number;
    private int discount;

    private DiscountCard(Builder builder) {
        setId(builder.id);
        setNumber(builder.number);
        setDiscount(builder.discount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

        DiscountCard that = (DiscountCard) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public static final class Builder {
        private Long id;
        private String number;
        private int discount;

        public Builder() {
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder number(String number) {
            this.number = number;
            return this;
        }

        public Builder discount(int discount) {
            this.discount = discount;
            return this;
        }

        public DiscountCard build() {
            return new DiscountCard(this);
        }
    }
}
