package ru.clevertec.model.repository.impl;

import ru.clevertec.model.datasource.CollectionDataSource;
import ru.clevertec.model.entity.Product;
import ru.clevertec.model.repository.ProductRepository;

import java.util.Optional;

public class ProductRepositoryImpl implements ProductRepository {
    private final CollectionDataSource dataSource;

    public ProductRepositoryImpl(CollectionDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return dataSource.getProducts().stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
    }
}
