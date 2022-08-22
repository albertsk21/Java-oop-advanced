import java.util.Scanner;
public class Main {

    public static void main(String[] args) {


        Scanner scanner =  new Scanner(System.in);

        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        double height = scanner.nextDouble();


        Box box = new ExternalBox(length,width,height);
        System.out.println(box);

    }
}
