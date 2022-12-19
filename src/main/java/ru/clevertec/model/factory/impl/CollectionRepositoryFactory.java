package ru.clevertec.model.factory.impl;

import ru.clevertec.model.datasource.CollectionDataSource;
import ru.clevertec.model.factory.RepositoryFactory;
import ru.clevertec.model.repository.DiscountCardRepository;
import ru.clevertec.model.repository.ProductRepository;
import ru.clevertec.model.repository.impl.DiscountCardRepositoryImpl;
import ru.clevertec.model.repository.impl.ProductRepositoryImpl;

public class CollectionRepositoryFactory implements RepositoryFactory {

    private final CollectionDataSource dataSource;

    public CollectionRepositoryFactory(CollectionDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ProductRepository getProductRepository() {
        return new ProductRepositoryImpl(dataSource);
    }

    @Override
    public DiscountCardRepository getDiscountCardRepository() {
        return new DiscountCardRepositoryImpl(dataSource);
    }
}
