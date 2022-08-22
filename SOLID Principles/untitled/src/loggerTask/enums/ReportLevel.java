package loggerTask.enums;

public enum ReportLevel {

    INFO, WARNING, ERROR, CRITICAL, FATAL;


    public static boolean isAbove(ReportLevel firstReportLevel, ReportLevel secondReportLevel){
        int firstIndex = ReportLevel.indexOf(firstReportLevel);
        int secondIndex = ReportLevel.indexOf(secondReportLevel);
        return firstIndex < secondIndex;
    }
    public static int indexOf(ReportLevel reportLevel){
        for (int i = 0; i <ReportLevel.values().length ; i++) {
            if(reportLevel.equals(ReportLevel.values()[i])){
                return i;
            }
        }
        return -1;
    }

}
