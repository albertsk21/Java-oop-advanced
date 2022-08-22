package carShop;

public class Main {

    public static void main(String[] args) {
        Car seat = new Seat("Leon", "Gray", 110, "Spain");

        System.out.println(String.format(
                "The %s is %s and has a %s horsepower engine.",
                seat.getModel(),
                seat.getColor(),
                seat.getHorsePower()));
        System.out.println(seat.toString());
    }
}
