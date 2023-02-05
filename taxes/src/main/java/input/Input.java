package input;

import java.util.Arrays;
import java.util.Map;

import items.Item;
import items.UnknownItem;
import shoppingcard.ShoppingCard;


public class Input {
    String inputStrLine;
    String[] inputSplitArr;
    Item[]items;


    public ShoppingCard proceed(String inputStrLine) {

        this.inputStrLine = inputStrLine;

        Item[] items = splitInputStrLine()
                .processQuantity()
                .processPrice()
                .processImport()
                .processExemptWithChatGPT()
                .returnReadyItems();


        ShoppingCard card = new ShoppingCard();
        Arrays.stream(items)
                .forEach(card::addItem);            //change to collect
        return card;

    }

    public Input splitInputStrLine() {

        inputSplitArr = new String[3];

        String quantity = inputStrLine.substring(0, inputStrLine.indexOf(" "));

        String price = inputStrLine.substring(inputStrLine.lastIndexOf(" ")).trim();

        String nameWithAt = inputStrLine.substring(inputStrLine.indexOf(" "), inputStrLine.lastIndexOf(" "));
        String name = nameWithAt.substring(0, nameWithAt.length()-2).trim();

        inputSplitArr[0] = quantity;
        inputSplitArr[1] = name;
        inputSplitArr[2] = price;

        return this;
    }

    public Input processQuantity(){
        String quantity = inputSplitArr[0];
        Integer quantityInt = Integer.parseInt(quantity);

        items = new Item[quantityInt];

        return this;
    }

    public Input processPrice() {
        double price = Double.parseDouble(inputSplitArr[2]);
        Item item =  new UnknownItem();


        return this;
    }

    public Item[] returnReadyItems() {
        return this.items;
    }

    public Input processExemptWithChatGPT() {
        return this;
    }

    public Input processImport() {
        return this;
    }



//    public static Input readLine(){}
}

