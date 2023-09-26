package com.mbal.saleportal.spring_template.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public static Timestamp stringToStartLocalDateTime(String inputDate, String pattern) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
            return Timestamp.valueOf(LocalDate.parse(inputDate, dateTimeFormatter).atStartOfDay());
        }catch (Exception e){
            return null;
        }
    }

    public static Timestamp stringToEndLocalDateTime(String inputDate, String pattern) {
        try {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
            return Timestamp.valueOf(LocalDate.parse(inputDate, dateTimeFormatter).atTime(LocalTime.MAX));
        }catch (Exception e){
            return null;
        }
    }

    public static String convertDateToString(Date date, String pattern) {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }
}
