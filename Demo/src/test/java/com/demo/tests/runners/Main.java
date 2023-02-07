package com.demo.tests.runners;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Main {
  public static void main(String[] args) {
    String startDate = "20170220";
    String endDate = "20211224";
    System.out.println("Tổng số ngày là : " + dateRangeInDays(startDate, endDate));
  }

  private static int dateRangeInDays(String startDate, String endDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    LocalDate start = LocalDate.parse(startDate, formatter);
    LocalDate end = LocalDate.parse(endDate, formatter);
    Period period = Period.between(start, end);
    return period.getDays() + period.getMonths() * 30 + period.getYears() * 365;
  }
}
