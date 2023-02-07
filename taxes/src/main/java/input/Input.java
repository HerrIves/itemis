package input;

import items.Item;
import items.UnknownItem;
import shoppingcard.ShoppingCard;

import java.io.InputStream;
import java.util.List;

public class Input {

    String inputStrLine;

    private int quantity;
    private String name;
    private double price;
    private boolean isImport, isExempt;

    public static List<String> readLines(InputStream in) {
        return null;
    }


    public ShoppingCard proceed(String inputStrLine) {

        this.inputStrLine = inputStrLine;

        return new ShoppingCard().addItem(
                Input.this
                        .processName()
                        .processQuantity()
                        .processPrice()
                        .processImport()
                        .processExemptWithChadGTP()
                        .buildItem()

                , quantity);

    }

    public Item buildItem() {
        Item item = new UnknownItem();
        item.setName(name);
        item.setPrice(price);
        item.setIsImport(isImport);
        item.setIsExempt(isExempt);

        return item;
    }

    public Input processName() {
        String nameWithAt = inputStrLine.substring(inputStrLine.indexOf(" "), inputStrLine.lastIndexOf(" "));
        name = nameWithAt.substring(0, nameWithAt.length() - 2).trim();

        return this;
    }

    public Input processQuantity() {
        String quantityStr = inputStrLine.substring(0, inputStrLine.indexOf(" "));
        quantity = Integer.parseInt(quantityStr);

        return this;
    }

    public Input processPrice() {
        String priceStr = inputStrLine.substring(inputStrLine.lastIndexOf(" ")).trim();
        price = Double.parseDouble(priceStr);

        return this;
    }

    public Input processImport() {
        if (inputStrLine.contains("imported"))
            this.isImport = true;

        return this;
    }

    public Input processExemptWithChadGTP() {
        this.setExempt(true);
        return this;
    }

    public int getQuantity() {        return quantity;    }
    public void setQuantity(int quantity) {        this.quantity = quantity;    }

    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }

    public double getPrice() {        return price;    }
    public void setPrice(double price) {        this.price = price;    }

    public boolean isImport() {        return isImport;    }
    public void setImport(boolean anImport) {        isImport = anImport;    }

    public boolean isExempt() {        return isExempt;    }
    public void setExempt(boolean exempt) {        isExempt = exempt;    }

}

