import org.junit.Assert;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private Database database;




    //TEST-CONSTRUCTOR
    @Test
    public void Insert16ElementsInConstructor() throws OperationNotSupportedException {
        this.database =  new Database(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void InsertAWrongElementsInConstructor() throws OperationNotSupportedException {
        this.database =  new Database(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17);
    }



    //TEST-ADD-METHOD
    @Test(expected =  OperationNotSupportedException.class)
    public void addNullElement() throws OperationNotSupportedException {
        this.database =  new Database(16);
        this.database.add(null);

    }

    @Test
    public void addNumberElement() throws OperationNotSupportedException {
        this.database = new Database(16);
        this.database.add(1);
    }


    //TEST-REMOVE-METHODS
    @Test
    public void removeElement() throws OperationNotSupportedException {
        this.database =  new Database(16);
        this.database.add(3);
        this.database.remove();

    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeNoNumber() throws OperationNotSupportedException {
        this.database =  new Database(16);
        this.database.remove();
        this.database.remove();

    }



    //TEST-METHOD-GET-ELEMENTS
    @Test
    public void getElementTest() throws OperationNotSupportedException {
        this.database =  new Database(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
        Integer[] array = new Integer[16];
        for (int i = 1; i < array.length; i++) {
            array[i] = i;
        }
        Assert.assertEquals(array.length,this.database.getElements().length);

    }




}
