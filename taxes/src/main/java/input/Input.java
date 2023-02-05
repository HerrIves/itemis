package input;

import java.util.ArrayList;
import java.util.List;
import items.Item;


public class Input {
    String inputStrLine;
    List<String> inputToList;
    Item item;


    public Item proceed(String inputStrLine) {

        this.inputStrLine = inputStrLine;

        Item item = toPartitions()
                .inputQuantityProcess()
                .inputPriceProcess()
                .inputImportProcess()
                .inputExempWithChatGPTProcess()
                .returnReadyItem();

        return item;
    }

    public Input toPartitions() {

        inputToList = new ArrayList<>();

        String quantity = inputStrLine.substring(0, inputStrLine.indexOf(" "));
        String price = inputStrLine.substring(inputStrLine.lastIndexOf(" "));
        String  name = inputStrLine.substring(inputStrLine.indexOf(" "), inputStrLine.lastIndexOf(" "));

        inputToList.add(quantity);
        inputToList.add(name);
        inputToList.add(price);

        return this;
    }

    public Item returnReadyItem() {
        return this.item;
    }

    public Input inputExempWithChatGPTProcess() {
        return this;
    }

    public Input inputImportProcess() {
        return this;
    }

    public Input inputPriceProcess() {
        return this;
    }

    public Input inputQuantityProcess() {
        return this;
    }



//    public static Input readLine(){}
}

