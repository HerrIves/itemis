package de.herrives.services;

import de.herrives.controllers.ConsoleInputController;
import de.herrives.models.items.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

import org.junit.Before;


import org.junit.Assert;
import org.junit.Test;


public class InputTest {
    public InputStream testInputStream1;
    public InputStream testInputStream2;


    @Before
    public void prepareInputData1() {
        byte[] testInputBytes = new StringBuffer()
                .append("1 test book at 12.49\n")
                .append("1  music CD at 14.99\n")
                .append("1 chocolate bar at 0.85\n")
                .toString()
                .getBytes(StandardCharsets.UTF_8);
        testInputStream1 = new ByteArrayInputStream(testInputBytes);
    }
    @Before
    public void prepareInputData2() {
        byte[] testInputBytes = new StringBuffer()
                .append("1 imported box of chocolates at 10.00\n")
                .append("1 imported bottle of perfume at 47.50\n")
                .toString()
                .getBytes(StandardCharsets.UTF_8);
        testInputStream2 = new ByteArrayInputStream(testInputBytes);
    }

    @Test
    public void readLinesTest() throws IOException {
        System.setIn(testInputStream1);

        List<String> lines = ConsoleInputController.readLines(testInputStream1);
        List<String> testLines = new ArrayList<>();
        testLines.add("1 test book at 12.49");
        testLines.add("1  music CD at 14.99");
        testLines.add("1 chocolate bar at 0.85");

        Assert.assertEquals(testLines, lines);
    }


    @Test
    public void proceedAllTest1() throws IOException {
        List<String> testStringList = ConsoleInputController.readLines(testInputStream1);
        testStringList.forEach(System.out::println);
        Map<Item, Integer> resInputBucket = ItemService.proceedAllInput(testStringList);


        Map<Item ,Integer> expectInputBucket = new HashMap<>();
        expectInputBucket.put(new UnknownItem("test book", 12.49), 1);
        expectInputBucket.put(new UnknownItem("music CD", 14.99), 1);
        expectInputBucket.put(new UnknownItem("chocolate bar", 0.85), 1);


        Assert.assertEquals(expectInputBucket, resInputBucket);
    }
    @Test
    public void proceedAllTest2() throws IOException {
        List<String> testStringList = ConsoleInputController.readLines(testInputStream2);
        testStringList.forEach(System.out::println);
        Map<Item, Integer> resInputBucket = ItemService.proceedAllInput(testStringList);


        Map<Item ,Integer> expectInputBucket = new HashMap<>();
        expectInputBucket.put(new UnknownItem("imported box of chocolates", 10.00), 1);
        expectInputBucket.put(new UnknownItem("imported bottle of perfume", 47.50), 1);


        Assert.assertEquals(expectInputBucket, resInputBucket);
    }


    @Test
    public void proceedTest(){
        Item expectItem = new UnknownItem("imported book im westen nichts neues", 12.49);
        expectItem.setIsImport(true);
        expectItem.setIsExempt(true);

        Map<Item, Integer> oneItemBucket = new ItemService().proceedEachInput("1 imported book im westen nichts neues at 12.49");

        Optional<Map.Entry<Item, Integer>> itemIntegerEntry = oneItemBucket.entrySet().stream().findAny();
        Item cardItem = itemIntegerEntry.get().getKey();
        Integer cardQuantity = itemIntegerEntry.get().getValue();

        Assert.assertEquals(expectItem, cardItem);
        Assert.assertEquals(1, cardQuantity.intValue());
        Assert.assertEquals(expectItem.getName(), cardItem.getName());
        Assert.assertEquals(expectItem.getPrice(), cardItem.getPrice(), 0.001);
        Assert.assertEquals(expectItem.getIsImported(), cardItem.getIsImported());
        Assert.assertEquals(expectItem.getIsExempt(), cardItem.getIsExempt());

    }

    @Test
    public void processNameTest() {
        ItemService input = new ItemService();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processName();

        Assert.assertEquals("imported test book", input.getName());
    }

    @Test
    public void processQuantityTest() {
        ItemService input = new ItemService();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processQuantity();

        Assert.assertEquals(2, input.getQuantity());
    }

    @Test
    public void processPriceTest() {
        ItemService input = new ItemService();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processPrice();

        Assert.assertEquals(12.49, input.getPrice(), 0.001);
    }

    @Test
    public void processImport() {
        ItemService input = new ItemService();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processImport();

        Assert.assertEquals(true, input.isImport());
    }

    @Test
    public void processExemptTest() throws IOException {
        ItemService input = new ItemService();
        input.setName("imported book im westen nichts neues");
        input.processExemptWithChadGTP();

        Assert.assertEquals(true, input.isExempt());
    }
}
