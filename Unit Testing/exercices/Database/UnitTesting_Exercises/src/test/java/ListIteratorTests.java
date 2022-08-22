import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {


    private ListIterator listIterator;

    @Before
    public void initializeListIterator() throws OperationNotSupportedException {
        this.listIterator =  new ListIterator("firstElement","secondElement","thirdElement");
    }


    //TEST-CONSTRUCTOR
    @Test(expected = OperationNotSupportedException.class)
    public void addNullInConstructor() throws OperationNotSupportedException {
        ListIterator newListIterator = new ListIterator(null);
    }

    //TEST-MOVE-METHOD
    @Test
    public void MoveReturnTrue(){
       boolean check = this.listIterator.move();
       Assert.assertTrue(check);
    }

    @Test
    public void MoveReturnFalse(){
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        boolean check = this.listIterator.move();
       Assert.assertFalse(check);
    }


    //TEST-HAS-NEXT-METHOD
    @Test
    public void isNextIndex(){
        this.listIterator.move();
        boolean check = this.listIterator.hasNext();
        Assert.assertTrue(check);

    }
    @Test
    public void isTheLastIndex(){
        this.listIterator.move();
        this.listIterator.move();
        this.listIterator.move();
        boolean check = this.listIterator.hasNext();
        Assert.assertFalse(check);
    }



    //TEST-PRINT-METHOD


    @Test
    public void printTheNextElement(){
        String nextElement = this.listIterator.print();
        Assert.assertEquals("firstElement",nextElement);
    }

    @Test(expected = IllegalStateException.class)
    public void printWithoutElement() throws IllegalStateException, OperationNotSupportedException {

        ListIterator emptyListIterator = new ListIterator();
        String nextElement = emptyListIterator.print();
        Assert.assertEquals("Invalid Operation!",nextElement);
    }





}
