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
                .append("1 test book at 12.49"+System.lineSeparator())
                .append("1  music CD at 14.99"+System.lineSeparator())
                .append("1 chocolate bar at 0.85"+System.lineSeparator());
        System.setIn(new ByteArrayInputStream(inputStringBuffer.toString().getBytes(StandardCharsets.UTF_8)));


        StringBuffer outStringBuffer = new StringBuffer()
                .append("1 test book: 12.49"+System.lineSeparator())
                .append("1 music CD: 16.49"+System.lineSeparator())
                .append("1 chocolate bar: 0.85"+System.lineSeparator())
                .append("Sales Taxes: 1.50"+System.lineSeparator())
                .append("Total: 29.83"+System.lineSeparator());

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
                .append("1 imported box of chocolates at 10.00"+System.lineSeparator())
                .append("1 imported bottle of perfume at 47.50"+System.lineSeparator());
        System.setIn(new ByteArrayInputStream(inputStringBuffer.toString().getBytes(StandardCharsets.UTF_8)));


        StringBuffer outStringBuffer = new StringBuffer()
                .append("1 imported box of chocolates: 10.50"+System.lineSeparator())
                .append("1 imported bottle of perfume: 54.65"+System.lineSeparator())
                .append("Sales Taxes: 7.65"+System.lineSeparator())
                .append("Total: 65.15"+System.lineSeparator());

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
                .append("1 imported bottle of perfume at 27.99"+System.lineSeparator())
                .append("1 bottle of perfume at 18.99"+System.lineSeparator())
                .append("1 packet of headache pills at 9.75"+System.lineSeparator())
                .append("1 imported box of chocolates at 11.25"+System.lineSeparator());
        System.setIn(new ByteArrayInputStream(inputStringBuffer.toString().getBytes(StandardCharsets.UTF_8)));


        StringBuffer outStringBuffer = new StringBuffer()
                .append("1 imported bottle of perfume: 32.19"+System.lineSeparator())
                .append("1 bottle of perfume: 20.89"+System.lineSeparator())
                .append("1 packet of headache pills: 9.75"+System.lineSeparator())
                .append("1 imported box of chocolates: 11.85"+System.lineSeparator())
                .append("Sales Taxes: 6.70"+System.lineSeparator())
                .append("Total: 74.68"+System.lineSeparator());

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        Start.main(null);

        System.setIn(consoleIn);
        System.setOut(consoleOut);

        System.out.println(byteArrayOutputStream.toString());

        Assert.assertEquals(outStringBuffer.toString(), byteArrayOutputStream.toString());
    }
}
