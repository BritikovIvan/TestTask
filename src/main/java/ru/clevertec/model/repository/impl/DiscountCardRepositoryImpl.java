package ru.clevertec.model.repository.impl;

import ru.clevertec.model.datasource.CollectionDataSource;
import ru.clevertec.model.entity.DiscountCard;
import ru.clevertec.model.repository.DiscountCardRepository;

import java.util.Optional;

public class DiscountCardRepositoryImpl implements DiscountCardRepository {

    private final CollectionDataSource dataSource;

    public DiscountCardRepositoryImpl(CollectionDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<DiscountCard> findByNumber(String number) {
        return dataSource.getCards().stream()
                .filter(card -> card.getNumber().equals(number))
                .findFirst();
    }
}
