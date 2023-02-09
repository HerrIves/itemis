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

                Map<Item, Integer> basket = lines.parallelStream()
                .map(new Input()::proceed)
                .flatMap(card -> card.getBasked().entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum, HashMap::new));

                new Receipt(new ShoppingCard(basket)).output();





    }
}