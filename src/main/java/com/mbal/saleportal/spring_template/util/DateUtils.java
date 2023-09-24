package com.mbal.saleportal.spring_template.util;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static final String PATTERN_yyyyDDmm = "yyyyMMdd";

    public static LocalDate convertStringToLocalDate(String inputDate) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(inputDate, dateTimeFormatter);
    }

    public static String convertDateToString(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
