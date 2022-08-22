package christmas;

import christmas.Present;
import christmas.PresentBag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import java.util.List;


public class ChristmasTests {
    private Present present;
    private PresentBag presentBag;

    @Before
    public void createInstances() {
        this.presentBag = new PresentBag();
        this.present = new Present("Name", 1.5);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionIfNullPresent() {
        this.presentBag.create(null);
    }


    //getCount

    @Test
    public void getCountShouldBeReturnCorrectNumber(){
        this.presentBag.create(present);
        Assert.assertEquals(1,this.presentBag.getCount());

    }


    //remove METHOD
    @Test(expected = NullPointerException.class)
    public void removeInsertNull(){
        this.presentBag.create(present);
        this.presentBag.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void removeInsertWhitespace(){
        this.presentBag.create(present);
        this.presentBag.remove(" ");
    }


    @Test
    public void removeInsertCorrectName(){
        this.presentBag.create(this.present);
        this.presentBag.remove("Name");
        Assert.assertEquals(this.present.getName(),"Name");
    }


    // getPresentWithLeastMagic METHOD
    @Test
    public void getPresentWithLeastMagic(){

        Present present = new Present("test1",1);
        Present present2 = new Present("test2",2);

        this.presentBag.create(present);
        this.presentBag.create(present2);

        Present getPresent = this.presentBag.getPresentWithLeastMagic();
        Assert.assertEquals(present,getPresent);

    }

    @Test
    public void getNullPresent(){
        PresentBag presentBag =  new PresentBag();
        Present present =  presentBag.getPresentWithLeastMagic();
        Assert.assertNull(present);
    }

    //getPresent METHOD

    @Test
    public void getPresentShouldBeReturnACorrectPresent(){
        this.presentBag.create(present);
        Present present = this.presentBag.getPresent("Name");
        Assert.assertEquals(this.present,present);
    }

    @Test
    public void getPresentShouldBeReturnANullPresent(){
        this.presentBag.create(this.present);
        Present present  = this.presentBag.getPresent("skcjs");
        Assert.assertNull(present);
    }

    //getPresents METHOD

    @Test
    public void getPresentsShouldBeReturnACorrectCollection(){
        this.presentBag.create(this.present);

        Present presentTest = new Present("test",1.7);
        this.presentBag.create(presentTest);

        List<Present> presents = new ArrayList<>();
        List<Present> getPresents =  new ArrayList<>(this.presentBag.getPresents());

        presents.add(this.present);
        presents.add(presentTest);


        Assert.assertEquals(presents,getPresents);
    }


}
