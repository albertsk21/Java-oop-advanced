import loggerTask.appenders.ConsoleAppender;
import loggerTask.appenders.FileAppender;
import loggerTask.appenders.interfaces.Appender;
import loggerTask.enums.ReportLevel;
import loggerTask.layouts.SimpleLayout;
import loggerTask.layouts.XmlLayout;
import loggerTask.layouts.interfaces.Layout;
import loggerTask.loggers.MessageLogger;
import loggerTask.loggers.interfaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bfr.readLine());

        List<Appender> appenders = new ArrayList<>();
        String[] line = null;
        for (int i = 0; i <n ; i++) {

            line =  bfr.readLine().split("\\s+");

            Appender appender = null;
            Layout layout = null;

               if(line[1].equals("XmlLayout")){
                   layout = new XmlLayout();
               }else{
                   layout = new SimpleLayout();
               }
               if(line[0].equals("ConsoleAppender")){
                   if(line.length == 3){
                       appender = new ConsoleAppender(layout, ReportLevel.valueOf(line[2]));
                   }else{
                       appender = new ConsoleAppender(layout);
                   }
               }else{
                   if(line.length == 3){
                       appender = new FileAppender(layout,ReportLevel.valueOf(line[2]));
                   }else {
                       appender = new FileAppender(layout);
                   }
               }
               appenders.add(appender);
        }




        line = bfr.readLine().split("\\|");
        Logger logger = new MessageLogger(appenders.toArray(Appender[]::new));
        while (!line[0].equals("END")){

            ReportLevel reportLevel  = ReportLevel.valueOf(line[0]);
            String date = line[1];
            String message = line[2];

            switch (reportLevel){
                case INFO -> logger.logInfo(date,message);
                case WARNING -> logger.logWarning(date,message);
                case ERROR -> logger.logError(date,message);
                case CRITICAL -> logger.logCritical(date,message);
                case FATAL -> logger.logFatal(date,message);
            }

            line = bfr.readLine().split("\\|");
        }

        System.out.println(logger);
    }






}
