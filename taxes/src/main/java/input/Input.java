package input;

import items.Item;


public class Input {
    String[] inputArr;

    public Item inputLine(String input) {

        Item item = inputPatipion(input)
                .inputQuantityProcess()
                .inputPriceProcess()
                .inputImportProcess()
                .inputExempWithChatGPTProcess()
                .returnReadyItem();

        return item;
    }

    public static Input readLine(){}
}

