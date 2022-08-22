package solid.layouts.interfaces;

import solid.enumerations.ReportLevel;

public interface Layout{
    String format(String date, ReportLevel reportLevel,String message);
}
