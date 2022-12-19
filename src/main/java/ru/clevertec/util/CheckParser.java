package ru.clevertec.util;

import ru.clevertec.dto.CheckDto;
import ru.clevertec.dto.CheckProductDto;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckParser {

    private static final String CARD_PARAM_NAME = "card";
    private static final String PARAM_SEPARATOR = "-";
    private CheckParser() {}

    public static CheckDto parseArgs(String[] args) {
        var argsList = Arrays.asList(args);
        if (argsList.isEmpty()) {
            return null;
        }

        var lastParam = argsList.get(argsList.size() - 1).split(PARAM_SEPARATOR);
        String cardNumber = null;
        if (lastParam[0].equalsIgnoreCase(CARD_PARAM_NAME)) {
            cardNumber = lastParam[1];
        }

        var checkProducts = new ArrayList<CheckProductDto>();
        for (String param:argsList) {
            var paramValues = param.split(PARAM_SEPARATOR);
            if (!paramValues[0].equalsIgnoreCase(CARD_PARAM_NAME)) {
                var checkProduct = new CheckProductDto();
                checkProduct.setProductId(Long.valueOf(paramValues[0]));
                checkProduct.setAmount(Integer.parseInt(paramValues[1]));
                checkProducts.add(checkProduct);
            }
        }

        var checkDto = new CheckDto();
        checkDto.setDiscountCardNumber(cardNumber);
        checkDto.setProducts(checkProducts);
        return checkDto;
    }
}
