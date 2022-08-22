import command.ConcreteCommand;
import command.Receiver;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {


        ConcreteCommand concreteCommand = new ConcreteCommand(new Receiver());
        concreteCommand.execute();


    }
}
