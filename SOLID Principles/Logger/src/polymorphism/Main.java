package polymorphism;


import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Layout simpleLayout = new SimpleLayout();


        Appender consoleAppender = new ConsoleAppender(simpleLayout);


        Logger logger = new MessageLogger(consoleAppender);

        logger.logError("3/26/2015 2:08:11 PM",
                "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM",
                "User Peter successfully registered.");

    }
}
