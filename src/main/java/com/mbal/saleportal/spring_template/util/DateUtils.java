package com.mbal.saleportal.spring_template.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String PATTERN_yyyyDDmm = "yyyyMMdd";
    public static final String PATTERN_DDmmyyyy = "dd/MM/yyyy";

    public static LocalDate stringToLocalDate(String inputDate, String pattern) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
            return LocalDate.parse(inputDate, dateTimeFormatter);
        }catch (Exception e){
            return null;
        }
    }

    public static String convertDateToString(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
