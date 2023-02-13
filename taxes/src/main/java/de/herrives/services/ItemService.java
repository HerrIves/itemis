package de.herrives.services;

import java.util.*;
import java.util.stream.Collectors;

import de.herrives.config.ChadGPTConfig;
import de.herrives.models.items.*;
import de.herrives.webclient.OpenAIClient;

public class ItemService {

    String inputStrLine;

    private int quantity;
    private String name;
    private double price;
    private boolean isImport, isExempt;

    static List<String> exceptions;

    static {
        exceptions = new ArrayList<>();
        exceptions.add("book");
        exceptions.add("pill");
        exceptions.add("chocolate");
    }


    public static Map<Item, Integer> proceedAllInput(List<String> inputStrings) {
        Map<Item, Integer> resultBucket;

        resultBucket = inputStrings.stream()
                .map(itemString -> new ItemService().proceedEachInput(itemString))
                .flatMap(oneItemBucket -> oneItemBucket.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum, LinkedHashMap::new));

        return resultBucket;
    }


    public Map<Item, Integer> proceedEachInput(String inputStrLine){

        this.inputStrLine = inputStrLine;

        Item item = ItemService.this
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

    public ItemService processName() {
        String nameWithAt = inputStrLine.substring(inputStrLine.indexOf(" "), inputStrLine.lastIndexOf(" "));
        name = nameWithAt.substring(0, nameWithAt.length() - 2).trim();

        return this;
    }

    public ItemService processQuantity() {
        String quantityStr = inputStrLine.substring(0, inputStrLine.indexOf(" "));
        quantity = Integer.parseInt(quantityStr);

        return this;
    }

    public ItemService processPrice() {
        String priceStr = inputStrLine.substring(inputStrLine.lastIndexOf(" ")).trim();
        price = Double.parseDouble(priceStr);

        return this;
    }

    public ItemService processImport() {
        if (inputStrLine.contains("import"))
            isImport = true;

        return this;
    }

    public ItemService processExemptWithChadGTP(){

        Properties config = new ChadGPTConfig().readProperties();
        OpenAIClient openAIClient = new OpenAIClient(config.getProperty("endPoint"), config.getProperty("apiKey"));

        String promptPattern = config.getProperty("promptPattern");

        isExempt = openAIClient.getAnswerFromAPI(promptPattern, name);
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

