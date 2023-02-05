package input;

import org.junit.Assert;
import org.junit.Test;
import items.Book;


public class inputTest {
    Input input;


    @Test
    public void inputTest(){
        Book testBook = new Book("imported test book", 12.49);
        testBook.setIsImport(true);
        testBook.setIsExempt(true);

        String inputString = "1 imported test book at 12.49";


        Assert.assertEquals(testBook, new Input().proceed(inputString));
    }

    @Test
    public void partitionTest(){
        Input input = new Input();
        input.inputStrLine = "1 imported test book at 12.49";
        input.toPartitions();

        Assert.assertEquals(3, input.inputToList.size());
    }
}
