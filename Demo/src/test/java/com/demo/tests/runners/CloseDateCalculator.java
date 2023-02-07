package com.demo.tests.runners;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CloseDateCalculator {
  public static String calculateCloseDate(String startDate, int monthsToAdd) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    Date parsedStartDate = dateFormat.parse(startDate);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(parsedStartDate);
    calendar.add(Calendar.MONTH, monthsToAdd);
    return dateFormat.format(calendar.getTime());
  }

  public static void main(String[] args) throws ParseException {
    String startDate = "20170228";
    int monthsToAdd = 1;
    System.out.println("Close date: " + calculateCloseDate(startDate, monthsToAdd));
  }
}
