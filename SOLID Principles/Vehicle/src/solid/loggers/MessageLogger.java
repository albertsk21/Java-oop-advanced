package solid.loggers;
import solid.appenders.interfaces.Appender;
import solid.enumerations.ReportLevel;
import solid.loggers.interfaces.Logger;

import java.io.IOException;

public class MessageLogger implements Logger {


    private  final Appender[] appends;

    public MessageLogger(Appender...args) {
        this.appends = args;
    }

    @Override
    public void logInfo(String date, String message) throws IOException {
        this.logMessage(date,ReportLevel.INFO,message);
    }

    @Override
    public void logError(String date, String message) throws IOException {
        this.logMessage(date,ReportLevel.ERROR, message);
    }

    @Override
    public void logWarning(String date, String message) throws IOException {
        this.logMessage(date,ReportLevel.WARNING, message);
    }

    @Override
    public void logCritical(String date, String message) throws IOException {
        this.logMessage(date,ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String date, String message) throws IOException {
        this.logMessage(date,ReportLevel.FATAL, message);
    }


    private void logMessage(String date,ReportLevel reportLevel,String message) throws IOException {

             for (Appender appender : appends) {
                 if(appender.getReportLevel().compareTo(reportLevel) <= 0){
                     appender.append(date, reportLevel, message);
                 }
             }

        }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Logger info\n\r");
        for (Appender appender : appends) {
            builder.append(appender.toString());
            builder.append(System.lineSeparator());

        }
        return builder.toString().trim();
    }

    }
