package solid;


import solid.appenders.ConsoleAppender;
import solid.appenders.FileAppender;
import solid.appenders.interfaces.Appender;;
import solid.enumerations.ReportLevel;
import solid.layouts.SimpleLayout;
import solid.layouts.XmlLayout;
import solid.layouts.interfaces.Layout;
import solid.loggers.MessageLogger;
import solid.loggers.interfaces.Logger;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {



        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Appender[] appenders = new Appender[n];
        int index = 0;

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            Appender appender;
            Layout layout;

            input = replacement(input);
            if (input[1].equals("SimpleLayout")) {
                layout = new SimpleLayout();
            } else {
                layout = new XmlLayout();
            }

            if (input[0].equals("ConsoleAppender")) {
                appender = new ConsoleAppender(layout);
            } else {
                appender = new FileAppender(layout);
            }
            if (input.length == 3) {
                appender.setReportLevel(ReportLevel.valueOf(input[2]));
            }
            appenders[index++] = appender;
        }

        Logger logger = new MessageLogger(appenders);

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] input = line.split("\\|");

            input = replacement(input);
            switch (ReportLevel.valueOf(input[0])) {
                case INFO:
                    logger.logInfo(input[1], input[2]);
                    break;
                case ERROR:
                    logger.logError(input[1], input[2]);

                    break;
                case FATAL:
                    logger.logFatal(input[1], input[2]);

                    break;
                case WARNING:
                    logger.logWarning(input[1], input[2]);

                    break;
                case CRITICAL:
                    logger.logCritical(input[1], input[2]);

                    break;
            }

            line = scanner.nextLine();

        }

        System.out.println(logger.toString());
    }

    public static String[] replacement(String[] input) {

        String[] output = new String[input.length];


        for (int i = 0; i < input.length; i++) {

            String currentItem = input[i].replaceAll("\\\\", "");

            output[i] = currentItem;

        }

        return output;
    }
}