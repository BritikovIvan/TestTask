package ru.clevertec.model.datasource;

import ru.clevertec.model.entity.Discount;
import ru.clevertec.model.entity.DiscountCard;
import ru.clevertec.model.entity.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CollectionDataSource {

    private static final CollectionDataSource INSTANCE = new CollectionDataSource();
    private final List<Product> products;
    private final List<DiscountCard> cards;

    private CollectionDataSource() {
        var tempProducts = new ArrayList<Product>();
        tempProducts.add(new Product.Builder().id(0L).name("Milk").price(BigDecimal.valueOf(1.9))
                .discount(new Discount.Builder().discountQuantity(5).discount(10).build()).build());
        tempProducts.add(new Product.Builder().id(1L).name("Bread").price(BigDecimal.valueOf(0.99)).build());
        tempProducts.add(new Product.Builder().id(2L).name("Eggs").price(BigDecimal.valueOf(3.2)).build());
        products = tempProducts;

        var tempCards = new ArrayList<DiscountCard>();
        tempCards.add(new DiscountCard.Builder().id(0L).number("12345").discount(15).build());
        tempCards.add(new DiscountCard.Builder().id(1L).number("54321").discount(5).build());
        cards = tempCards;
    };

    public static CollectionDataSource getInstance() {
        return INSTANCE;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<DiscountCard> getCards() {
        return cards;
    }
}
