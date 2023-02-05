package input;

import items.Item;

import java.util.List;


public class Input {
    List<String> inputToList;

    public Item proceed(String input) {

        Item item = inputPatipion(input)
                .inputQuantityProcess()
                .inputPriceProcess()
                .inputImportProcess()
                .inputExempWithChatGPTProcess()
                .returnReadyItem();

        return item;
    }

//    public static Input readLine(){}
}

