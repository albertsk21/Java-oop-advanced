package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AquariumTests {

    private Aquarium aquarium;


    @Before
    public void initialize(){
        Fish f = new Fish("name");
        Fish f1 = new Fish("name1");
        Fish f2 = new Fish("name2");
        this.aquarium = new Aquarium("aqua", 10);

        this.aquarium.add(f);
        this.aquarium.add(f1);
        this.aquarium.add(f2);
    }


    //TEST METHOD getName
    @Test
    public void noExceptionInGetName(){
      String name =  this.aquarium.getName();
      String expected = "aqua";
      Assert.assertEquals(expected,name);
    }

    //TEST SETTER SET NAME
    @Test
    public void noExceptionSetName() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = Aquarium.class.getDeclaredMethod("setName",String.class);
        method.setAccessible(true);
        method.invoke(this.aquarium,"aquarium");
        String expected = "aquarium";
        Assert.assertEquals(expected,this.aquarium.getName());
    }

    //TEST CONSTRUCTOR

    //setName
    @Test(expected = NullPointerException.class)
    public void exceptionNullInvalidName(){
        Aquarium aquarium = new Aquarium(null, 10);

    }
    @Test(expected = NullPointerException.class)
    public void exceptionWhitespaceInvalidName(){
        Aquarium aquarium = new Aquarium("   ", 10);

    }

    //setCapacity
    @Test(expected = IllegalArgumentException.class)
    public void ExceptionNegativeNumberCapacity(){
        Aquarium aquarium = new Aquarium("aquarium", -1);
    }


    //TEST method getCapacity
    @Test
    public void getCorrectCapacity(){
        int expected = 10;
        int currentCapacity = this.aquarium.getCapacity();
        Assert.assertEquals(expected,currentCapacity);
    }


    //Test getCount method
    @Test
    public void correctNumberGetCount(){
        int expected = 3;
        int currentCounter = this.aquarium.getCount();
        Assert.assertEquals(expected,currentCounter);
    }

    //Test add method
    @Test
    public void addCorrectFish(){
        Aquarium aquarium =  new Aquarium("name",2);
        aquarium.add(new Fish("FreshFish"));

        int currentCounter = aquarium.getCount();
        int expected = 1;
        Assert.assertEquals(expected,currentCounter);

    }
    @Test(expected = IllegalArgumentException.class)
    public void addFishWithFullCapacityGenerateException(){
        Aquarium aquarium =  new Aquarium("name",1);
        aquarium.add(new Fish("FreshFish"));
        aquarium.add(new Fish("SwagFish"));

    }


    //Test remove method
    @Test
    public void removeCorrectFish(){
        this.aquarium.remove("name");
        int expectedCounter = 2;
        int currentCounter = this.aquarium.getCount();
        Assert.assertEquals(expectedCounter,currentCounter);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeMethodShouldBeReturnAException(){
        this.aquarium.remove("swagFish");
    }

    //Test sellFish Methods

    @Test
    public void sellFishIsAvailable(){

      Fish currentFish =  this.aquarium.sellFish("name");
      Fish expectedFish = new Fish("name");
      expectedFish.setAvailable(false);

      Assert.assertEquals(currentFish.getName(),expectedFish.getName());
      Assert.assertEquals(expectedFish.isAvailable(),currentFish.isAvailable());

    }

    @Test(expected = IllegalArgumentException.class)
    public void sellFishShouldBeReturnAnException(){
        this.aquarium.sellFish("swagFish");
    }

    //Test method report
    @Test
    public void returnCorrectReport(){
        String output = this.aquarium.report();
        String expectedOutput = "Fish available at aqua: name, name1, name2";
        Assert.assertEquals(expectedOutput,output);
    }
}

