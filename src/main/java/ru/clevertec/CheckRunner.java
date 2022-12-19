package ru.clevertec;

import ru.clevertec.model.datasource.CollectionDataSource;
import ru.clevertec.model.factory.RepositoryFactory;
import ru.clevertec.model.factory.impl.CollectionRepositoryFactory;
import ru.clevertec.service.CheckService;
import ru.clevertec.service.impl.CheckServiceImpl;
import ru.clevertec.util.CheckParser;
import ru.clevertec.util.CheckWriter;

public class CheckRunner {
    public static void main(String[] args) {
        var dataSource = CollectionDataSource.getInstance();
        RepositoryFactory repositoryFactory = new CollectionRepositoryFactory(dataSource);
        CheckService checkService = new CheckServiceImpl(repositoryFactory.getProductRepository(), repositoryFactory.getDiscountCardRepository());
        var checkDto = CheckParser.parseArgs(args);
        var check = checkService.createCheck(checkDto);
        CheckWriter.writeToConsole(check);
    }
}