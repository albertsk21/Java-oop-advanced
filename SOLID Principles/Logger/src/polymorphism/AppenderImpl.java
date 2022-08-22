package polymorphism;

import java.io.IOException;

public class AppenderImpl implements Appender {

    private final Layout layout;
    private ReportLevel reportLevel;
    private int loggedMessages;

    @Override
    public void append(String date, ReportLevel reportLevel, String message) throws IOException {

    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {

    }

    @Override
    public ReportLevel getReportLevel() {
        return null;
    }
}
