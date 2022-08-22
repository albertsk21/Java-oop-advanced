import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p05_CustomLinkedList.CustomLinkedList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomLinkedListTests {

    private CustomLinkedList<String> customLinkedList;
    private Method[] methods;

    @Before
    public void initialize(){
        this.customLinkedList = new CustomLinkedList<>();

        this.customLinkedList.add("1");
        this.customLinkedList.add("2");
        this.customLinkedList.add("3");

        Class<CustomLinkedList> customLinkedListClass = CustomLinkedList.class;
        methods = customLinkedListClass.getMethods();

    }




    /**
     * TEST-ALL-PUBLIC-METHODS

     */

    //test remove method
    @Test
    public void RemoveUnknownElement(){
       int index = this.customLinkedList.remove("jfkhxbc");
        Assert.assertEquals(-1,index);
    }
    @Test
    public void RemoveARealElement(){

        int index = this.customLinkedList.remove("1");
        Assert.assertEquals(0,index);
    }

    /**test removeAt method
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void InsertAInvalidIndex(){
        this.customLinkedList.removeAt(54);
    }

    @Test
    public void InsertAValidIndex(){
        this.customLinkedList.removeAt(1);
    }


    /**test indexOf method
     *
     */
    @Test
    public void findCorrectElement(){
       int index = this.customLinkedList.indexOf("1");
       Assert.assertEquals(0,index);
    }

   @Test
    public void findAUnknownElement(){
       int index = this.customLinkedList.indexOf("433");
       Assert.assertEquals(-1,index);
    }

    /**test contains method
     *
     */
    @Test
    public void ContainACorrectElement(){
        boolean check = this.customLinkedList.contains("1");
        Assert.assertTrue(check);
    }

    @Test
    public void ContainAUnknownElement(){
        boolean check = this.customLinkedList.contains("22");
        Assert.assertFalse(check);
    }

    /**test setter
     *
     */
    @Test(expected =  IllegalArgumentException.class)
    public void setWithAWrongIndex(){
       this.customLinkedList.set(-1,"4");
    }

    @Test
    public void setWithACorrectIndex(){
       this.customLinkedList.set(1,"4");
    }

    /**test getter
    *test getCount
     */
    @Test
    public void TestGetCount() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<CustomLinkedList> customLinkedListClass = CustomLinkedList.class;
        Method method = customLinkedListClass.getDeclaredMethod("getCount");
        method.setAccessible(true);
        int count = (int) method.invoke(this.customLinkedList);
        Assert.assertEquals(3,count);



    }

    /**test get
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void insertAWrongIndex() {
        this.customLinkedList.get(323);

    }
    @Test
    public void insertACorrectIndex(){
      String stringElement =  this.customLinkedList.get(1);
      Assert.assertEquals("2",stringElement);
    }

}
