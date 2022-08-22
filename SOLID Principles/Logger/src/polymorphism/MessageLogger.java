package polymorphism;

import java.io.IOException;

public class MessageLogger implements Logger {
    private final Appender[] appenders;

    public MessageLogger(Appender[] appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String date, String message) throws IOException {
    }

    @Override
    public void logWarning(String date, String message) throws IOException {

    }

    @Override
    public void logError(String date, String message) throws IOException {

    }

    @Override
    public void logCritical(String date, String message) throws IOException {

    }

    @Override
    public void logFatal(String date, String message) throws IOException {

    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Logger info\n\r");
        for (Appender appender : appenders) {
            builder.append(appender.toString());
            builder.append(System.lineSeparator());

        }
        return builder.toString().trim();
    }

}
