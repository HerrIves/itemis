package input;

import items.Item;
import items.UnknownItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Input {

    String inputStrLine;

    private int quantity;
    private String name;
    private double price;
    private boolean isImport, isExempt;

    public static List<String> readLines(InputStream in) throws IOException {
        List<String>lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line;

        while ((line = reader.readLine()) != null){
            if (line.equals(""))break;
            lines.add(line);
        }
        return lines;
    }

    public static Map<Item, Integer> proceedAll(List<String> inputStrings) {
        Map<Item, Integer> resultBucket;

        resultBucket = inputStrings.stream()
                .map(new Input()::proceed)
                .flatMap(oneItemBucket -> oneItemBucket.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum, LinkedHashMap::new));


        return resultBucket;
    }


    public Map<Item, Integer> proceed(String inputStrLine) {

        this.inputStrLine = inputStrLine;

        Item item = Input.this
                .processName()
                .processQuantity()
                .processPrice()
                .processImport()
                .processExemptWithChadGTP()
                .buildItem();

        Map<Item, Integer> oneItemBucket = new HashMap<Item, Integer>();
        oneItemBucket.put(item, quantity);
        return oneItemBucket;
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
        List<String>exceptions = new ArrayList<>();
        exceptions.add("book");
        exceptions.add("pills");
        exceptions.add("chocolate");
        exceptions.add("chocolate");

        isExempt = exceptions.stream()
                .anyMatch(exception->inputStrLine.contains(exception));

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

