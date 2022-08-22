package solid.appenders;

import solid.enumerations.ReportLevel;
import solid.layouts.interfaces.Layout;

import java.io.IOException;

public class ConsoleAppender extends AppenderImpl {
    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    protected ConsoleAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) throws IOException {
        System.out.println(this.format(date, reportLevel, message));
    }
}
