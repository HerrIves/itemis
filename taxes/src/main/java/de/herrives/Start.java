package de.herrives;

import de.herrives.input.*;
import de.herrives.models.items.*;
import de.herrives.shoppingcard.ShoppingCard;
import de.herrives.shoppingreceipt.Receipt;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class Start {
    public static void main(String[] args) throws IOException {

        List<String> lines = Input.readLines(System.in);
        Map<Item, Integer> resultBucket = Input.proceedAll(lines);
        new Receipt(new ShoppingCard(resultBucket)).output();

    }
}