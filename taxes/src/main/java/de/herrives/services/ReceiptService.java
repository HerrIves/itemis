package de.herrives.services;

import de.herrives.models.items.*;
import de.herrives.models.ShoppingCard;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static de.herrives.services.TaxesService.taxesOutForItem;

public class ReceiptService {
    private ShoppingCard card;
    private double allTaxes;
    private double total;

    public ShoppingCard getCard() {        return card;    }
    public double getAllTaxes() {        return allTaxes;    }
    public double getTotal() {        return total;    }

    public ReceiptService(ShoppingCard card) {
        this.card = card;
    }

    private List<String> calculate(){
        List<String> outputList = new ArrayList<>();

        card.getBasked().entrySet().stream()
                .forEach(entry -> {
                    Item item = entry.getKey();
                    Integer quantity = entry.getValue();
                    Double itemTaxes = taxesOutForItem(item);

                    outputList.add(
                            String.format(Locale.ENGLISH, "%d %s: %.02f", quantity,item.getName(), (item.getPrice() + itemTaxes)));
                    allTaxes += quantity * itemTaxes;
                    total += quantity * (item.getPrice() + itemTaxes);
                });
        outputList.add(String.format(Locale.ENGLISH, "Sales Taxes: %.02f", allTaxes));
        outputList.add(String.format(Locale.ENGLISH, "Total: %.02f", total));

        return outputList;
    }

    public void output(PrintStream out){
        calculate().stream()
                .forEach(out::println);
    }
    public void output(){
        output(System.out);
    }
}
