package ru.clevertec.dto;

import java.util.List;
import java.util.Objects;

public class CheckDto {
    private List<CheckProductDto> products;
    private String discountCardNumber;

    public List<CheckProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<CheckProductDto> products) {
        this.products = products;
    }

    public String getDiscountCardNumber() {
        return discountCardNumber;
    }

    public void setDiscountCardNumber(String discountCardNumber) {
        this.discountCardNumber = discountCardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckDto checkDto = (CheckDto) o;

        if (!Objects.equals(products, checkDto.products)) return false;
        return Objects.equals(discountCardNumber, checkDto.discountCardNumber);
    }

    @Override
    public int hashCode() {
        int result = products != null ? products.hashCode() : 0;
        result = 31 * result + (discountCardNumber != null ? discountCardNumber.hashCode() : 0);
        return result;
    }
}
