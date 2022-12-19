package ru.clevertec.dto;

public class CheckProductDto {
    private Long productId;
    private int amount;

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckProductDto that = (CheckProductDto) o;

        if (amount != that.amount) return false;
        return productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = 31 * result + amount;
        return result;
    }
}
