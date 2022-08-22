package loggerTask.layouts.interfaces;

import loggerTask.enums.ReportLevel;

public interface Layout {
    String format(String date, ReportLevel reportLevel, String message);
}
