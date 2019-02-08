package config;

import java.util.Date;

public class DateRequired {
    public static java.sql.Date makeSqlDate(Date date) {
        if (date == null) return null;
        return new java.sql.Date(date.getTime());
    }
    public static Date makeJavaDate(java.sql.Date date) {
        if (date == null) return null;
        return new  Date(date.getTime());
    }

}
