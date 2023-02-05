package input;

import java.util.Arrays;

import items.Item;
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

        CharSequence nameWithAt = inputStrLine.subSequence(inputStrLine.indexOf(" "), inputStrLine.lastIndexOf(" "));
        String name = nameWithAt.subSequence(0, nameWithAt.length()-2).toString().trim();

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

    public Item[] returnReadyItems() {
        return this.items;
    }

    public Input processExemptWithChatGPT() {
        return this;
    }

    public Input processImport() {
        return this;
    }

    public Input processPrice() {
        return this;
    }



//    public static Input readLine(){}
}

