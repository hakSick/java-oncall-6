package view;

import java.util.List;
import model.Date;

public class OutputView {

    public static void printInfo(Date checkedDate, int monthNum, List<String> normalNames, List<String> holidayNames) {
        int startIdx = checkedDate.weekList.indexOf(checkedDate.week);
        String checkrest = "";
        Boolean change = false;
        for (int i = 1; i < monthNum + 1; i++) {
            String currentWeek = checkedDate.weekList.get((startIdx + i - 1) % 7);
            System.out.print(checkedDate.month + "월 " + i + "일 " + currentWeek + " ");
            checkHoliday(checkedDate, i);
            // 휴일 처리
            if (currentWeek != "토" && currentWeek != "일" && checkedDate.isHoliday) {
                System.out.print("(휴일) ");
                int holidayIndex = (i - 1) % holidayNames.size();  // 휴일 리스트 순환
                if (holidayNames.get(holidayIndex) == checkrest) {
                    System.out.println(holidayNames.get((i) % holidayNames.size()));
                    change = true;
                }
                if (change) {
                    System.out.println(holidayNames.get((i - 2) % holidayNames.size()));
                    checkrest = holidayNames.get((i - 2) % holidayNames.size());
                }
                if (!change) {
                    System.out.println(holidayNames.get(holidayIndex));
                    checkrest = holidayNames.get(holidayIndex);
                }
            }

            // 주말 처리
            if (currentWeek == "토" || currentWeek == "일") {
                int holidayIndex = (i - 1) % holidayNames.size();  // 휴일 리스트 순환
                if (holidayNames.get(holidayIndex) == checkrest) {
                    System.out.println(holidayNames.get((i) % holidayNames.size()));
                    change = true;
                }
                if (change) {
                    System.out.println(holidayNames.get((i - 2) % holidayNames.size()));
                    checkrest = holidayNames.get((i - 2) % holidayNames.size());
                }
                if (!change) {
                    System.out.println(holidayNames.get(holidayIndex));
                    checkrest = holidayNames.get(holidayIndex);
                }
            }

            // 일반 날 처리
            if (!(currentWeek == "토" || currentWeek == "일"||checkedDate.isHoliday)) {
                int normalIndex = (i - 1) % normalNames.size();  // 일반 날 리스트 순환
                if (normalNames.get(normalIndex) == checkrest) {
                    System.out.println(normalNames.get((i) % normalNames.size()));
                    change = true;
                }
                if (change) {
                    System.out.println(normalNames.get((i - 2) % normalNames.size()));
                    checkrest = normalNames.get((i - 2) % normalNames.size());
                }
                if (!change) {
                    System.out.println(normalNames.get(normalIndex));
                    checkrest = normalNames.get(normalIndex);
                }
            }
        }
    }

    public static void checkHoliday(Date date, int monthNum) {
        date.isHoliday = false;

        if (date.month == 1 && monthNum == 1) {
            date.isHoliday = true;
        }

        if (date.month == 3 && monthNum == 1) {
            date.isHoliday = true;
        }
        if (date.month == 5 && monthNum == 5) {
            date.isHoliday = true;
        }
        if (date.month == 6 && monthNum == 6) {
            date.isHoliday = true;
        }
        if (date.month == 8 && monthNum == 15) {
            date.isHoliday = true;
        }
        if (date.month == 10 && monthNum == 3) {
            date.isHoliday = true;
        }
        if (date.month == 10 && monthNum == 9) {
            date.isHoliday = true;
        }
        if (date.month == 12 && monthNum == 25) {
            date.isHoliday = true;
        }
    }

}
