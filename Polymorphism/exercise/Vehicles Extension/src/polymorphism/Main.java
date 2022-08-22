package polymorphism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr =  new BufferedReader( new InputStreamReader(System.in));


        //---INPUT-CAR---//
        String[] input = bfr.readLine().split(" ");
        double carFuelQuantity = Double.parseDouble(input[1]);
        double carLitersPerKm = Double.parseDouble(input[2]);
        double carTankCapacity = Double.parseDouble(input[3]);
        Vehicle car = new Car(carFuelQuantity, carLitersPerKm, carTankCapacity);


        //---INPUT-TRUCK---//
        input = bfr.readLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(input[1]);
        double truckLitersPerKm = Double.parseDouble(input[2]);
        double truckTankCapacity = Double.parseDouble(input[3]);
        Vehicle truck =  new Truck(truckFuelQuantity,truckLitersPerKm,truckTankCapacity);


        //---INPUT-BUSS---//
        input = bfr.readLine().split(" ");
        double busFuelQuantity = Double.parseDouble(input[1]);
        double busLitersPerKm = Double.parseDouble(input[2]);
        double busTankCapacity = Double.parseDouble(input[3]);
        Vehicle bus =  new Bus(busFuelQuantity,busLitersPerKm, busTankCapacity);


        //---COMMANDS---//
        int iteration = Integer.parseInt(bfr.readLine());

        for (int i = 0; i < iteration; i++) {

            input = bfr.readLine().split(" ");

            if(input[0].equals("Drive") ){


                if( input[1].equals("Car")){
                    double distance = Double.parseDouble(input[2]);
                    car.drive(distance);

                }else if( input[1].equals("Truck")){
                    double distance = Double.parseDouble(input[2]);
                    truck.drive(distance);

                }else if(input[1].equals("Bus")){
                    double distance = Double.parseDouble(input[2]);
                    bus.drive(distance,false);

                }


            }else if(input[0].equals("DriveEmpty") &&  input[1].equals("Bus")){

                double distance = Double.parseDouble(input[2]);
                bus.drive(distance,true);

            }else if(input[0].equals("Refuel")){

                if(input[1].equals("Car")){

                    try{
                        double refuelingLiters = Double.parseDouble(input[2]);
                        car.refuelling(refuelingLiters);
                    }catch (IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }

                }else if(input[1].equals("Truck")){

                    try{
                        double refuelingLiters = Double.parseDouble(input[2]);
                        truck.refuelling(refuelingLiters);

                    }catch (IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }

                }else if(input[1].equals("Bus")){
                    try{
                        double refuelingLiters = Double.parseDouble(input[2]);
                        bus.refuelling(refuelingLiters);

                    }catch (IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }
                }
;

            }

        }


        System.out.printf("Car: %.2f%n",car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n",truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n",bus.getFuelQuantity());

    }

}
