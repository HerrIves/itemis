import input.Input;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StartTest {
    @Test
    public void mainTest() throws IOException {
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
}
