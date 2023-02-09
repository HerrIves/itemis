import input.Input;
import items.Item;
import shoppingcard.ShoppingCard;
import shoppingreceipt.Receipt;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Start {
    public static void main(String[] args) throws IOException {

        List<String> lines = Input.readLines(System.in);
        Map<Item, Integer> resultBucket = Input.proceedAll(lines);

        new Receipt(new ShoppingCard(resultBucket)).output();


    }
}