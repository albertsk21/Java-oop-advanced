package loggerTask.appenders.interfaces;


import loggerTask.enums.ReportLevel;

public interface Appender {

    void append(String date, ReportLevel reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);
    ReportLevel getReportLevel();

}
