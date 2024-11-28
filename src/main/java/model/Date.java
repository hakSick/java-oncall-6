package model;

import java.util.Arrays;
import java.util.List;

public class Date {
    public int month;
    public String week;
    public int day;
    public Boolean isHoliday = false;
    public List<String> weekList = Arrays.asList("월", "화", "수", "목", "금", "토", "일");

    public Date(int month, String week, int day) {
        this.month = month;
        this.week = week;
        this.day = day;
    }

    public enum MonthLimit {
        JANUARY(1, 31),
        FEBRUARY(2, 28),
        MARCH(3, 31),
        APRIL(4, 30),
        MAY(5, 31),
        JUNE(6, 30),
        JULY(7, 31),
        AUGUST(8, 31),
        SEPTEMBER(9, 30),
        OCTOBER(10, 31),
        NOVEMBER(11, 30),
        DECEMBER(12, 31);

        private final int monthNumber;
        private final int daysLimit;

        MonthLimit(int monthNumber, int days) {
            this.monthNumber = monthNumber;
            this.daysLimit = days;
        }

        public int getMonthNumber() {
            return monthNumber;
        }

        public int getDays() {
            return daysLimit;
        }

        public static int getDaysByMonthNumber(Date date) {
            for (MonthLimit month : MonthLimit.values()) {
                if (month.getMonthNumber() == date.month) {
                    return month.getDays();
                }
            }
            throw new IllegalArgumentException();
        }
    }

}
