package shopAndGoods;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShopTest {

    private Shop shop;
    private Map<String, Goods> shelves ;
    @Before
    public void initialize(){
        this.shop = new Shop();
        this.shelves = new LinkedHashMap<>();
        this.shelves.put("Shelves1", null);
        this.shelves.put("Shelves2", null);
        this.shelves.put("Shelves3", null);
        this.shelves.put("Shelves4", null);
        this.shelves.put("Shelves5", null);
        this.shelves.put("Shelves6", null);
        this.shelves.put("Shelves7", null);
        this.shelves.put("Shelves8", null);
        this.shelves.put("Shelves9", null);
        this.shelves.put("Shelves10", null);
        this.shelves.put("Shelves11", null);
        this.shelves.put("Shelves12", null);
    }

    //TEST Constructor



    // TEST METHOD GetShelves
    @Test
    public void getShelvesShouldBeReturnACorrectMap(){
        Assert.assertEquals(this.shelves,this.shop.getShelves());
    }

    // TEST METHOD addGoods

    @Test
    public void AddACorrectGoods() throws OperationNotSupportedException {
        Goods goods = new Goods("Shelves12","328738");
        this.shelves.put("Shelves12",goods);
        this.shop.addGoods("Shelves12",goods);
        Assert.assertEquals(this.shelves,this.shop.getShelves());
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionAddAValueInTheShelfNotExist() throws OperationNotSupportedException {
        Goods goods = new Goods("Shelves13","328738");
        this.shop.addGoods("Shelves13",goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionAddAValueButIsAlreadyTaken() throws OperationNotSupportedException {
        Goods goods = new Goods("Shelves12","328738");
        Goods cloneGoods = new Goods("Shelves12","834834");
        this.shop.addGoods("Shelves12",goods);
        this.shop.addGoods("Shelves12",cloneGoods);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void exceptionAddAValueButIsAlreadyInShelf() throws OperationNotSupportedException {
        Goods goods = new Goods("Shelves12","328738");
        this.shop.addGoods("Shelves12",goods);
        this.shop.addGoods("Shelves11",goods);
    }

    //Test RemoveGoods
    @Test
    public void removeACorrectGoods() throws OperationNotSupportedException {
        Goods goods = new Goods("Dessert","7237332");
        this.shop.addGoods("Shelves1",goods);
        String output = this.shop.removeGoods("Shelves1",goods);
        String expectedOutput = "Goods: 7237332 is removed successfully!";
        Assert.assertEquals(expectedOutput,output);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionRemoveAShelfNotExist(){
        Goods goods = new Goods("Dessert","7237332");
        this.shop.removeGoods("2323232",goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionGoodShelfNotExist(){
        Goods goods = new Goods("Dessert","7237332");
        this.shop.removeGoods("Shelves12",goods);
    }



}