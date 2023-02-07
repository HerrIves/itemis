import input.Input;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class StartTest {
    @Test
    public void mainTest(){

        StringBuffer inputStringBuffer = new StringBuffer()
                .append("1 test book at 12.49\n")
                .append("1  music CD at 14.99\n")
                .append("1 chocolate bar at 0.85\n");
        ByteArrayInputStream in = new ByteArrayInputStream(inputStringBuffer.toString().getBytes(StandardCharsets.UTF_8));


        StringBuffer outStringBuffer = new StringBuffer()
                .append("1 book: 12.49\n")
                .append("1 music CD: 16.49\n")
                .append("1 chocolate bar: 0.85\n")
                .append("Sales Taxes: 1.50\n")
                .append("Total: 29.83\n");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(byteArrayOutputStream);

        Input.readLines(in)
                .proceed()
                .getOutput(out);

        Assert.assertEquals(outStringBuffer.toString(), byteArrayOutputStream.toString());
    }
}
