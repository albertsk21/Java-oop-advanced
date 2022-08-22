package rpg_tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 1;
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;
    private static int EXPECTED_DURABILITY = AXE_DURABILITY - 1;


    private Axe axe;
    private Dummy dummy;


    @Before
    public void initialize(){
        this.axe = new Axe(AXE_ATTACK,AXE_DURABILITY);
        this.dummy =  new Dummy(DUMMY_HEALTH,DUMMY_XP);
    }

    @Test
    public void weaponAttacksLosesDurability(){
    // Act
        this.axe.attack(dummy);
    // Assert
        Assert.assertEquals(EXPECTED_DURABILITY,this.axe.getDurability());
    }


    @Test(expected = IllegalStateException.class)
    public void attackWithABrokenAxe(){

        this.axe.setDurabilityPoints(1);

        //Act
        axe.attack(dummy);
        axe.attack(dummy);

    }

}
