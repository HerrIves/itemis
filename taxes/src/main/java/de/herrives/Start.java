package de.herrives;

import de.herrives.controllers.ConsoleInputController;
import de.herrives.services.*;
import de.herrives.models.items.*;
import de.herrives.models.ShoppingCard;
import de.herrives.shoppingreceipt.Receipt;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Start {
    public static void main(String[] args) throws IOException {

        List<String> lines = ConsoleInputController.readLines();
        Map<Item, Integer> resultBucket = ItemService.proceedAllInput(lines);
        new Receipt(new ShoppingCard(resultBucket)).output();

    }
}