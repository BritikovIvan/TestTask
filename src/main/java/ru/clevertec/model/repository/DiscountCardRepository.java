package ru.clevertec.model.repository;

import ru.clevertec.model.entity.DiscountCard;

import java.util.Optional;

public interface DiscountCardRepository {
    Optional<DiscountCard> findByNumber(String number);
}
