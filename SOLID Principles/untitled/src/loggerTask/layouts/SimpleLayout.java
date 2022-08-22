package loggerTask.layouts;

import loggerTask.layouts.interfaces.Layout;
import loggerTask.enums.ReportLevel;

public class SimpleLayout implements Layout {
    private final String formatterLayout = "%s - %s - %s";

    @Override
    public String format(String dateTime, ReportLevel reportLevel, String message) {
        return String.format(formatterLayout,dateTime,reportLevel,message) ;
    }
}
