package input;

import items.Item;

import java.util.List;


public class Input {
    String inputString;
    List<String> inputToList;

    public Item proceed(String inputString) {

        this.inputString = inputString;

        Item item = toPartipion()
                .inputQuantityProcess()
                .inputPriceProcess()
                .inputImportProcess()
                .inputExempWithChatGPTProcess()
                .returnReadyItem();

        return item;
    }

//    public static Input readLine(){}
}

