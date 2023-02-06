package input;

import items.Item;
import items.UnknownItem;
import lombok.Data;
import shoppingcard.ShoppingCard;

@Data
public class Input {
    String inputStrLine;

    private int quantity;
    private String name;
    private double price;
    private boolean isImport, isExempt;



    public ShoppingCard proceed(String inputStrLine) {

                this.inputStrLine = inputStrLine;

                return new ShoppingCard().addItem(
                        Input.this
                                .processName()
                                .processQuantity()
                                .processPrice()
                                .processImport()
                                .processExemptWithChatGPT()
                                .buildItem()

                                ,quantity);

    }

    private Item buildItem() {
        Item item = new UnknownItem();
        item.setName(this.name);
        item.setPrice(price);

        return item;
    }

    public Input processName() {
        String nameWithAt = inputStrLine.substring(inputStrLine.indexOf(" "), inputStrLine.lastIndexOf(" "));
        name = nameWithAt.substring(0, nameWithAt.length()-2).trim();

        return this;
    }

    public Input processQuantity(){
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
        if (name.contains("imported"))
            this.setImport(true);

        return this;
    }

    public Input processExemptWithChatGPT() {
        return this;
    }



//    public static Input readLine(){}
}

