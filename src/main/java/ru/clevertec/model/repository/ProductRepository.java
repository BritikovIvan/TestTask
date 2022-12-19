package ru.clevertec.model.repository;

import ru.clevertec.model.entity.Product;

import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);
}
