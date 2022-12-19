package ru.clevertec.util;

import ru.clevertec.model.entity.Check;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

public class CheckWriter {
    private CheckWriter() {}

    public static void writeToConsole(Check check) {
        var formatInfo = "%-4.4s %-20.20s %10.10s %10.10s";
        var formatPrice = "%-24.24s %22.22s";
        var newLine = System.getProperty("line.separator");
        var dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        var checkToConsole = new StringBuilder();
        checkToConsole.append("CASH RECEIPT").append(newLine);
        checkToConsole.append("DATE: ")
                .append(check.getDateTime().format(dateFormatter))
                .append(newLine);
        checkToConsole.append(String.format(formatInfo, "QTY", "DESCRIPTION", "PRICE", "TOTAL")).append(newLine);
        check.getProducts().forEach(checkProduct -> checkToConsole.append(String.format(formatInfo, checkProduct.getAmount(),
                checkProduct.getProduct().getName(),
                "$" + checkProduct.getPrice(),
                "$" + checkProduct.getPrice().multiply(BigDecimal.valueOf(checkProduct.getAmount()))))
                .append(newLine));
        checkToConsole.append(String.format(formatPrice, "ORDER TOTAL:", "$" + check.getTotalPrice())).append(newLine);
        checkToConsole.append(String.format(formatPrice, "SALE:", "$" + check.getTotalPrice().subtract(check.getDiscountPrice()))).append(newLine);
        checkToConsole.append(String.format(formatPrice, "GRAND TOTAL:", "$" + check.getDiscountPrice()));

        System.out.println(checkToConsole);
    }
}
