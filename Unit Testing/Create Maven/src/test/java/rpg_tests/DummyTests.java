package rpg_tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Dummy;

public class DummyTests {
    private static final int DUMMY_HEALTH = 20;
    private static final int DUMMY_XP = 10;


    private Dummy dummy;

    @Before
    public void initializeDummy(){
        this.dummy =  new Dummy(DUMMY_HEALTH, DUMMY_XP);
    }

    @Test
    public void DummyLosesHealthIfIsAttacked(){
        //Act
        this.dummy.takeAttack(15);
        //Assert
        Assert.assertEquals(5,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void DummyIsDeadCanAttackHim(){

        this.dummy.takeAttack(20);
        this.dummy.takeAttack(9);
    }

    @Test
    public void DummyIdDeadGiveXP(){

        dummy.takeAttack(20);
        int XP = dummy.giveExperience();
    }



    @Test(expected = IllegalStateException.class)
    public void aliveDummyCantGiveXP(){
        dummy.giveExperience();
    }



}
