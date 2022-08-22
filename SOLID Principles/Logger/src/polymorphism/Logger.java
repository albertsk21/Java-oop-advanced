package polymorphism;

import java.io.IOException;

interface Logger {

    void logInfo(String date,String message) throws IOException;
    void logWarning(String date,String message) throws IOException;
    void logError(String date,String message) throws IOException;
    void logCritical(String date,String message) throws IOException;
    void logFatal(String date,String message) throws IOException;
}
