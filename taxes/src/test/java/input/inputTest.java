package input;

import org.junit.Assert;
import org.junit.Test;
import items.Book;


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
    public void toPartitionTest(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.splitInputStrLine();

        Assert.assertEquals(3, input.inputSplitArr.length);
        Assert.assertEquals("2", input.inputSplitArr[0]);
        Assert.assertEquals("imported test book", input.inputSplitArr[1]);
        Assert.assertEquals("12.49", input.inputSplitArr[2]);
    }



    @Test
    public void quantityProcessTest(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.splitInputStrLine();
        input.processQuantity();

        Assert.assertEquals(2, input.items.length);
    }

    @Test
    public void  priceProcessTest(){
        Input input = new Input();
        input.inputStrLine = "2 imported test book at 12.49";
        input.splitInputStrLine();
        input.processQuantity();
        input.processPrice();

        Assert.assertEquals(12.49, input.);
    }
}
