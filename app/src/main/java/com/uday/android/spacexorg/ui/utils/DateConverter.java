package com.uday.android.spacexorg.ui.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateConverter {

    private static final String formatPattern1 = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
    private static final String formatPattern2 = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String formatOutputPattern = "MMM dd, yyyy hh:mm a";

    //--------------------------------- StringToDate Format----------------------//
    public static String convertToDateSimpleFormat(String dateUTC) {


        SimpleDateFormat inputFormat = new SimpleDateFormat(formatPattern1,Locale.getDefault());
        inputFormat.setTimeZone(Calendar.getInstance().getTimeZone());

        SimpleDateFormat format;
        Date date;
        try {
            format = new SimpleDateFormat(formatOutputPattern, Locale.getDefault());
            date = inputFormat.parse(dateUTC);
            return format.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertHistoryToDateSimpleFormat(String dateUTC) {

        SimpleDateFormat inputFormat = new SimpleDateFormat(formatPattern2,Locale.getDefault());
        inputFormat.setTimeZone(Calendar.getInstance().getTimeZone());

        SimpleDateFormat format;
        Date date = null;
        format = new SimpleDateFormat(formatOutputPattern, Locale.getDefault());
        try {
            date = inputFormat.parse(dateUTC);
        } catch (ParseException e) {
            e.printStackTrace();
            return convertToDateSimpleFormat(dateUTC);
        }
        return format.format(date);
    }
}
