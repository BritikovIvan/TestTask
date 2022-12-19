package ru.clevertec.service.impl;

import ru.clevertec.dto.CheckDto;
import ru.clevertec.dto.CheckProductDto;
import ru.clevertec.model.entity.Check;
import ru.clevertec.model.entity.CheckProduct;
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
            products.add(new CheckProduct.Builder()
                                .product(product.get())
                                .amount(productDto.getAmount())
                                .price(product.get().getPrice())
                                .build());
        }

        var totalPrice = BigDecimal.valueOf(0);

        for (CheckProduct checkProduct : products) {
            totalPrice = totalPrice.add(checkProduct.getPrice().multiply(BigDecimal.valueOf(checkProduct.getAmount())));
        }

        var check = new Check.Builder()
                .products(products)
                .totalPrice(totalPrice)
                .discountPrice(totalPrice)
                .dateTime(LocalDateTime.now())
                .build();
        check.getProducts().forEach(product -> product.setCheck(check));
        if (checkDto.getDiscountCardNumber() != null) {
            var discountCard = cardRepository.findByNumber(checkDto.getDiscountCardNumber());
            if (discountCard.isEmpty()) {
                throw new RuntimeException();
            }
            check.setCard(discountCard.get());
            var discountPriceNotRounded =check.getTotalPrice().multiply(BigDecimal.valueOf((100 - discountCard.get().getDiscount()) / 100.0));
            check.setDiscountPrice(discountPriceNotRounded
                    .round(new MathContext(discountPriceNotRounded.precision() - discountPriceNotRounded.scale() + 2)));
        }
        return check;
    }
}
