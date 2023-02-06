package input;

import org.junit.Assert;
import org.junit.Test;


public class inputTest {


//    @Test
//    public void inputTest(){
//        Book testBook = new Book("imported test book", 12.49);
//        testBook.setIsImport(true);
//        testBook.setIsExempt(true);
//
//        String inputString = "1 imported test book at 12.49";
//
//
//        Assert.assertEquals(testBook, new Input().proceed(inputString));
//    }

    @Test
    public void processNameTest(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processName();

        Assert.assertEquals("imported test book", input.getName());
    }

    @Test
    public void processQuantityTest(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processQuantity();

        Assert.assertEquals(2, input.getQuantity());
    }

    @Test
    public void processPriceTest(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processPrice();

        Assert.assertEquals(12.49, input.getPrice(), 0.001);
    }

    @Test
    public void processImport(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processImport();

        Assert.assertEquals(true, input.isImport());
    }

    @Test
    public void processExemptTest(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.processImport();

        Assert.assertEquals(true, input.isExempt());
    }
}
