package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {

    private ComputerManager computerManager;
    private Computer computer1;
    private Computer computer2;
    private Computer computer3;
    @Before
    public void initialize(){
        computerManager = new ComputerManager();
        this.computer1 = new Computer("1","Samsung",1244);
        this.computer2 = new Computer("2","MacBook",1676);
        this.computer3 = new Computer("3","Huawei",1200);
        computerManager.addComputer(computer1);
        computerManager.addComputer(computer2);
        computerManager.addComputer(computer3);
    }


    // Test getComputers METHOD
    @Test
    public void getComputersShouldBeReturnACorrectList(){
        List<Computer> computers = new ArrayList<>();
        computers.add(this.computer1);
        computers.add(this.computer2);
        computers.add(this.computer3);
        List<Computer> extract = this.computerManager.getComputers();
        Assert.assertEquals(computers,extract);
    }


    //Test getCount METHOD
    @Test
    public void getCountShouldBeReturnACorrectCount(){
        int correctCounter = 3;
        int extractCounter = this.computerManager.getCount();

        Assert.assertEquals(correctCounter,extractCounter);
    }

    //Test addComputers METHOD

    @Test
    public void addACorrectComputer(){
        Computer computer4 =  new Computer("4","Xiaomi",1233);
        this.computerManager.addComputer(computer4);
        List<Computer> extractComputersList = this.computerManager.getComputers();
        List<Computer> correctComputersList = new ArrayList<>();
        correctComputersList.add(this.computer1);
        correctComputersList.add(this.computer2);
        correctComputersList.add(this.computer3);
        correctComputersList.add(computer4);

        Assert.assertEquals(correctComputersList,extractComputersList);

    }

    @Test(expected = IllegalArgumentException.class)
    public void addAExistingComputer(){
        Computer copyFirstComputer = new Computer("1","Samsung",1244);
        this.computerManager.addComputer(copyFirstComputer);
    }


    // Test removeComputer METHOD
    @Test
    public void removeACorrectComputer(){
        this.computerManager.removeComputer("1","Samsung");
        List<Computer> extractComputersList = this.computerManager.getComputers();
        List<Computer> correctComputersList = new ArrayList<>();
        correctComputersList.add(this.computer2);
        correctComputersList.add(this.computer3);

        Assert.assertEquals(correctComputersList,extractComputersList);

    }
    @Test(expected = IllegalArgumentException.class)
    public void removeAWrongComputer(){
        this.computerManager.removeComputer("13","Samsung");
    }


    //Test getComputer METHOD

    @Test
    public void getACorrectComputer(){
        Computer extractComputer =  this.computerManager.getComputer("1","Samsung");
        Computer correctComputer = this.computer1;
        Assert.assertEquals(correctComputer,extractComputer);

    }

    @Test( expected = IllegalArgumentException.class)
    public void getAWrongComputerWithException(){
     this.computerManager.getComputer("6","Samsung");
    }


    // Test getComputersByManufacturer METHOD

    @Test
    public void getComputersByManufacturerCorrectList(){
        Computer computer4 = new Computer("2","Sony",323);
        Computer computer5 = new Computer("2","RepublicGamers",323);
        Computer computer6 = new Computer("2","Asus",323);

        this.computerManager.addComputer(computer4);
        this.computerManager.addComputer(computer5);
        this.computerManager.addComputer(computer6);

        List<Computer> correctComputers = new ArrayList<>();
        correctComputers.add(this.computer2);
        correctComputers.add(computer4);
        correctComputers.add(computer5);
        correctComputers.add(computer6);

        List<Computer> extractListByManufacturer = this.computerManager.getComputersByManufacturer("2");
        Assert.assertEquals(correctComputers,extractListByManufacturer);
    }





}