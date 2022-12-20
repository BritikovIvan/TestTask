package ru.clevertec.service.impl;

import ru.clevertec.dto.CheckDto;
import ru.clevertec.dto.CheckProductDto;
import ru.clevertec.model.entity.*;
import ru.clevertec.model.repository.DiscountCardRepository;
import ru.clevertec.model.repository.ProductRepository;
import ru.clevertec.service.CheckService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class CheckServiceImpl implements CheckService {

    private final ProductRepository productRepository;
    private final DiscountCardRepository cardRepository;

    public CheckServiceImpl(ProductRepository productRepository, DiscountCardRepository cardRepository) {
        this.productRepository = productRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public Check createCheck(CheckDto checkDto) {
        if (checkDto == null) {
            return null;
        }
        var products = new ArrayList<CheckProduct>();
        for (CheckProductDto productDto : checkDto.getProducts()) {
            var product = productRepository.findById(productDto.getProductId());
            if (product.isEmpty()) {
                throw new RuntimeException();
            }
            products.add(createCheckProduct(product.get(), productDto.getAmount()));
        }

        var price = BigDecimal.valueOf(0);
        var totalPrice = BigDecimal.valueOf(0);
        DiscountCard discountCard = null;

        if (checkDto.getDiscountCardNumber() != null) {
            var card = cardRepository.findByNumber(checkDto.getDiscountCardNumber());
            if (card.isEmpty()) {
                throw new RuntimeException();
            }
            discountCard = card.get();

            var discountAmount = BigDecimal.valueOf(0);
            var cardDiscount = BigDecimal.valueOf(discountCard.getDiscount() / 100.0);
            for (CheckProduct product: products) {
                price = price.add(product.getTotalPrice());
                if (product.getDiscount() == null) {
                    discountAmount = discountAmount.add(product.getTotalPrice().multiply(cardDiscount));
                }
            }
            totalPrice = roundPrice(price.subtract(discountAmount));
        } else {
            price = products.stream()
                    .map(CheckProduct::getTotalPrice)
                    .reduce(BigDecimal.valueOf(0), BigDecimal::add);
            totalPrice = price;
        }

        var check = new Check.Builder()
                .products(products)
                .price(price)
                .totalPrice(totalPrice)
                .dateTime(LocalDateTime.now())
                .card(discountCard)
                .build();
        check.getProducts().forEach(product -> product.setCheck(check));

        return check;
    }

    private CheckProduct createCheckProduct(Product product, int amount) {
        var totalPrice = product.getPrice().multiply(BigDecimal.valueOf(amount));
        Discount discount = null;
        if (product.getDiscount() != null && product.getDiscount().getDiscountQuantity() <= amount) {
            totalPrice = roundPrice(totalPrice.multiply(BigDecimal.valueOf((100 - product.getDiscount().getDiscount()) / 100.0)));
            discount = product.getDiscount();
        }
        return new CheckProduct.Builder()
                .product(product)
                .amount(amount)
                .price(product.getPrice())
                .discount(discount)
                .totalPrice(totalPrice)
                .build();
    }

    private BigDecimal roundPrice(BigDecimal priceNotRounded) {
        return priceNotRounded.round(new MathContext(priceNotRounded.precision() - priceNotRounded.scale() + 2));
    }
}
