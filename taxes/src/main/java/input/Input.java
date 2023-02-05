package input;

import java.util.ArrayList;
import java.util.List;
import items.Item;


public class Input {
    String inputStrLine;
    List<String> inputSplitList;
    Item[]items;


    public Item[] proceed(String inputStrLine) {

        this.inputStrLine = inputStrLine;

        Item[] items = toPartitions()
                .quantityProcess()
                .priceProcess()
                .importProcess()
                .exemptProcessWithChatGPT()
                .returnReadyItems();

        return items;
    }

    public Input toPartitions() {

        inputSplitList = new ArrayList<>();

        String quantity = inputStrLine.substring(0, inputStrLine.indexOf(" "));

        String price = inputStrLine.substring(inputStrLine.lastIndexOf(" ")).trim();

        CharSequence nameWithAt = inputStrLine.subSequence(inputStrLine.indexOf(" "), inputStrLine.lastIndexOf(" "));
    String name = nameWithAt.subSequence(0, nameWithAt.length()-2).toString().trim();


        inputSplitList.add(quantity);
        inputSplitList.add(name);
        inputSplitList.add(price);

        return this;
    }

    public Input quantityProcess() {
        return this;
    }

    public Item[] returnReadyItems() {
        return this.items;
    }

    public Input exemptProcessWithChatGPT() {
        return this;
    }

    public Input importProcess() {
        return this;
    }

    public Input priceProcess() {
        return this;
    }



//    public static Input readLine(){}
}

