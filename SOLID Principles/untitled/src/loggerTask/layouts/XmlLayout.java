package loggerTask.layouts;

import loggerTask.enums.ReportLevel;
import loggerTask.layouts.interfaces.Layout;

public class XmlLayout implements Layout {

    private final String xmlFormat = "<log>\n" +
                                     "\t<date>%s</date>\n" +
                                     "\t<level>%s</level>\n" +
                                     "\t<message>%s</message>\n" +
                                     "</log>";

    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format(xmlFormat,date,reportLevel,message);
    }
}
