package de.herrives.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class InputControllerTest {
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
}
