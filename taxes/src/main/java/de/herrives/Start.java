package de.herrives;

import de.herrives.controllers.ConsoleInputController;
import de.herrives.services.*;
import de.herrives.models.ShoppingCard;
import de.herrives.services.ReceiptService;

import java.io.IOException;
import java.util.List;


public class Start {
    public static void main(String[] args) throws IOException {

        List<String> lines = ConsoleInputController.readLines();

        ShoppingCard shoppingCard = new ShoppingCard(ItemService.proceedAllInput(lines));

        new ReceiptService(shoppingCard).output();

    }
}