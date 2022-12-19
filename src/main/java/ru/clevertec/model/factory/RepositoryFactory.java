package ru.clevertec.model.factory;

import ru.clevertec.model.repository.DiscountCardRepository;
import ru.clevertec.model.repository.ProductRepository;

public interface RepositoryFactory {
    ProductRepository getProductRepository();
    DiscountCardRepository getDiscountCardRepository();
}
