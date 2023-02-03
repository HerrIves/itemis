package shoppingreceipt;

import items.Item;
import shoppingcard.ShoppingCard;

import java.util.ArrayList;
import java.util.List;
import static itemtaxes.Taxes.taxesOutForItem;

public class Receipt {
    private ShoppingCard card;
    private double allTaxes;
    private double total;

    public ShoppingCard getCard() {        return card;    }
    public double getAllTaxes() {        return allTaxes;    }
    public double getTotal() {        return total;    }

    public Receipt(ShoppingCard card) {
        this.card = card;
    }

    public void output(){
        calculate().stream()
                .forEach(System.out::println);
        System.out.println(String.format("Sales Taxes: %.02f", allTaxes));
        System.out.println(String.format("Total: %.02f", total));

    }

    private List<String> calculate(){
        List<String> outputList = new ArrayList<>();
        card.getBasked().entrySet().stream()
                .forEach(entry -> {
                    Item item = entry.getKey();
                    Integer quantity = entry.getValue();
                    Double itemTaxes = taxesOutForItem(item);

                    outputList.add(
                            String.format("%d %s: %.02f", quantity,item.getName(), (item.getPrice() + itemTaxes)));
                    allTaxes += quantity * itemTaxes;
                    total += quantity * (item.getPrice() + itemTaxes);
                });

        return outputList;
    }
}
