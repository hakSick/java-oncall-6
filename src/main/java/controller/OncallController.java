package controller;

import static controller.InputIsValid.checkLength;
import static controller.InputIsValid.checkNames;
import static model.Date.MonthLimit.getDaysByMonthNumber;
import static view.InputView.askMonthDay;
import static controller.InputIsValid.checkMonthDay;
import static view.InputView.askRestNames;
import static view.InputView.reAskMonthDay;
import static view.InputView.askNormalNames;
import static view.InputView.reAskNormalNames;
import static view.InputView.reAskRestNames;
import static view.OutputView.printInfo;


import java.util.List;
import model.Date;

public class OncallController {
    public static void run() {
        Date checkedDate = checkMonthDay(askMonthDay());
        while (checkedDate == null) {
            checkedDate = checkMonthDay(reAskMonthDay());
        }

        List<String> normalNames = null;
        List<String> holidayNames = null;

         do{
            normalNames = checkNames(askNormalNames());
            while (normalNames == null) {
                normalNames = checkNames(reAskNormalNames());
            }

            holidayNames = checkNames(askRestNames());
            while (holidayNames == null) {
                holidayNames = checkNames(reAskNormalNames());
            }

        }while (checkLength(normalNames, holidayNames) == null);

        printInfo(checkedDate, getDaysByMonthNumber(checkedDate), normalNames, holidayNames);
    }
}
