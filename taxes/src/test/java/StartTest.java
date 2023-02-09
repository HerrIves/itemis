import input.Input;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StartTest {
    @Test
    public void mainTestInput1() throws IOException {
        InputStream consoleIn = System.in;
        PrintStream consoleOut = System.out;

        StringBuffer inputStringBuffer = new StringBuffer()
                .append("1 test book at 12.49\n")
                .append("1  music CD at 14.99\n")
                .append("1 chocolate bar at 0.85\n");
        System.setIn(new ByteArrayInputStream(inputStringBuffer.toString().getBytes(StandardCharsets.UTF_8)));


        StringBuffer outStringBuffer = new StringBuffer()
                .append("1 test book: 12.49\n")
                .append("1 music CD: 16.49\n")
                .append("1 chocolate bar: 0.85\n")
                .append("Sales Taxes: 1.50\n")
                .append("Total: 29.83\n");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        Start.main(null);

        System.setIn(consoleIn);
        System.setOut(consoleOut);

        System.out.println(byteArrayOutputStream.toString());

        Assert.assertEquals(outStringBuffer.toString(), byteArrayOutputStream.toString());
    }
    @Test
    public void mainTestInput2() throws IOException {
        InputStream consoleIn = System.in;
        PrintStream consoleOut = System.out;

        StringBuffer inputStringBuffer = new StringBuffer()
                .append("1 imported box of chocolates at 10.00\n")
                .append("1 imported bottle of perfume at 47.50\n");
        System.setIn(new ByteArrayInputStream(inputStringBuffer.toString().getBytes(StandardCharsets.UTF_8)));


        StringBuffer outStringBuffer = new StringBuffer()
                .append("1 imported box of chocolates: 10.50\n")
                .append("1 imported bottle of perfume: 54.65\n")
                .append("Sales Taxes: 7.65\n")
                .append("Total: 65.15\n");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        Start.main(null);

        System.setIn(consoleIn);
        System.setOut(consoleOut);

        System.out.println(byteArrayOutputStream.toString());

        Assert.assertEquals(outStringBuffer.toString(), byteArrayOutputStream.toString());
    }
    @Test
    public void mainTestInput3() throws IOException {
        InputStream consoleIn = System.in;
        PrintStream consoleOut = System.out;

        StringBuffer inputStringBuffer = new StringBuffer()
                .append("1 imported bottle of perfume at 27.99\n")
                .append("1 bottle of perfume at 18.99\n")
                .append("1 packet of headache pills at 9.75\n")
                .append("1 imported box of chocolates at 11.25\n");
        System.setIn(new ByteArrayInputStream(inputStringBuffer.toString().getBytes(StandardCharsets.UTF_8)));


        StringBuffer outStringBuffer = new StringBuffer()
                .append("1 imported bottle of perfume: 32.19\n")
                .append("1 bottle of perfume: 20.89\n")
                .append("1 packet of headache pills: 9.75\n")
                .append("1 imported box of chocolates: 11.85\n")
                .append("Sales Taxes: 6.70\n")
                .append("Total: 74.68\n");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        Start.main(null);

        System.setIn(consoleIn);
        System.setOut(consoleOut);

        System.out.println(byteArrayOutputStream.toString());

        Assert.assertEquals(outStringBuffer.toString(), byteArrayOutputStream.toString());
    }
}
