package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GarageTests {
    private Garage garage;
    private final Car firstCar = new Car("Audi",500,122324);
    private final Car secondCar = new Car("Mercedes",600,12324);
    private final Car thirdCar = new Car("Dacia",100,1324);

    @Before
    public void initialize(){


        this.garage = new Garage();

        this.garage.addCar(this.firstCar);
        this.garage.addCar(this.secondCar);
        this.garage.addCar(this.thirdCar);

    }

    //Test getCars Method
    @Test
    public void shouldBeReturnACorrectCollection(){
        Collection<Car> expected = new ArrayList<>();
        expected.add(this.firstCar);
        expected.add(this.secondCar);
        expected.add(this.thirdCar);

        Collection<Car> current = this.garage.getCars();

        Assert.assertEquals(expected,current);

    }

    //Test getCount Method
    @Test
    public void shouldBeReturnACorrectSize(){

        int expected = 3;
        int current  = this.garage.getCount();

        Assert.assertEquals(expected,current);

    }

    //Test addCar Method

    @Test(expected = IllegalArgumentException.class)
    public void ShouldBeReturnAnExceptionAddCarr(){
        this.garage.addCar(null);
    }
    @Test
    public void addAnCorrectCar(){
        Car car = new Car("Bugatti",500,1324);
        this.garage.addCar(car);
    }


    //Test findAllCarsWithMaxSpeedAbove Method

    @Test
    public void returnAnCorrectListCar(){
        List<Car> expectedSortedCar = new ArrayList<>();
        expectedSortedCar.add(this.firstCar);
        expectedSortedCar.add(this.secondCar);

        List<Car> currentListCar =  this.garage.findAllCarsWithMaxSpeedAbove(110);

        Assert.assertEquals(expectedSortedCar,currentListCar);

    }

    //Test getTheMostExpensiveCar method

    @Test
    public void ShouldBeReturnMostExpensiveCar(){
       Assert.assertEquals(this.firstCar,this.garage.getTheMostExpensiveCar());
    }

    //Test findAllCarsByBrand Method
    @Test
    public void ShouldBeReturnCorrectCarByBrand(){

        Car audi = new Car("Audi",700,12345);
        List<Car> expectedListCar = new ArrayList<>();
        expectedListCar.add(firstCar);
        expectedListCar.add(audi);
        this.garage.addCar(audi);
        Assert.assertEquals(expectedListCar,this.garage.findAllCarsByBrand("Audi"));
    }

}