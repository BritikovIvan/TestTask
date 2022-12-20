package ru.clevertec.util;

import ru.clevertec.model.entity.Check;

import java.time.format.DateTimeFormatter;

public class CheckWriter {

    private CheckWriter() {}

    public static void writeToConsole(Check check) {
        System.out.println(createCheckString(check));
    }

    private static String createCheckString(Check check) {
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
        check.getProducts().forEach(checkProduct -> {
            if (checkProduct.getDiscount() == null)
                checkToConsole.append(String.format(formatInfo, checkProduct.getAmount(),
                                checkProduct.getProduct().getName(),
                                "$" + checkProduct.getPrice(),
                                "$" + checkProduct.getTotalPrice()))
                        .append(newLine);
            else {
                checkToConsole.append(String.format(formatInfo, checkProduct.getAmount(),
                                checkProduct.getProduct().getName(),
                                "$" + checkProduct.getPrice(), ""))
                        .append(newLine)
                        .append(String.format(formatInfo, "",
                                "discount " + checkProduct.getDiscount().getDiscount() + " %",
                                "",
                                "$" + checkProduct.getTotalPrice()))
                        .append(newLine);
            }
        });
        checkToConsole.append(String.format(formatPrice, "ORDER TOTAL:", "$" + check.getPrice())).append(newLine);
        checkToConsole.append(String.format(formatPrice, "DISCOUNT CARD SALE:", "$" + check.getPrice().subtract(check.getTotalPrice()))).append(newLine);
        checkToConsole.append(String.format(formatPrice, "GRAND TOTAL:", "$" + check.getTotalPrice()));
        return checkToConsole.toString();
    }
}
