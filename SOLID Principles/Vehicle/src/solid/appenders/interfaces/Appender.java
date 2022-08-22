package solid.appenders.interfaces;

import solid.enumerations.ReportLevel;

import java.io.IOException;

public interface Appender {
    void append(String date, ReportLevel reportLevel, String message) throws IOException;
    void setReportLevel(ReportLevel reportLevel);
    ReportLevel getReportLevel();
}