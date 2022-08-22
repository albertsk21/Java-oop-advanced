package solid.appenders;

import solid.appenders.interfaces.Appender;
import solid.customFiles.LogFile;
import solid.customFiles.interfaces.File;
import solid.enumerations.ReportLevel;
import solid.layouts.interfaces.Layout;

import java.io.IOException;
public class FileAppender extends AppenderImpl {
    private File file;
    public FileAppender(Layout layout) {
        super(layout);

    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    public void setFile(File file){
        this.file = file;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if (this.file == null){
            try {
                this.setFile(new LogFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str = this.format(date,reportLevel,message);

        file.appendBuffer(str);
        this.file.write();

    }

    @Override
    public String toString() {
        return super.toString() + ", File size: "+ this.file.getSize();
    }
}