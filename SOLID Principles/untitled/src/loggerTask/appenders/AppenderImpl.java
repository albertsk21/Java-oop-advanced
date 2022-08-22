package loggerTask.appenders;

import loggerTask.enums.ReportLevel;
import loggerTask.layouts.interfaces.Layout;
import loggerTask.appenders.interfaces.Appender;

public abstract class AppenderImpl implements Appender {

    private Layout layout;
    private ReportLevel reportLevel;
    private int loggedMessages;

    protected AppenderImpl(Layout layout) {
        this.layout = layout;
        this.loggedMessages = 0;
        this.setReportLevel(ReportLevel.INFO);
    }


    public AppenderImpl(Layout layout, ReportLevel reportLevel) {
        this.layout = layout;
        this.setReportLevel(reportLevel);
    }

    protected String format(String date, ReportLevel reportLevel, String message){
        this.loggedMessages++;
        return this.layout.format(date,reportLevel,message);
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.toString(),
                this.loggedMessages);
    }
}
