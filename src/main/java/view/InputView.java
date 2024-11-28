package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String askMonthDay() {
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        return Console.readLine();
    }

    public static String reAskMonthDay(){
        System.out.println("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        System.out.println("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
        return Console.readLine();
    }

    public static String askNormalNames(){
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return Console.readLine();
    }

    public static String reAskNormalNames(){
        System.out.println("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        System.out.println("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return Console.readLine();
    }

    public static String askRestNames(){
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return Console.readLine();
    }

    public static String reAskRestNames(){
        System.out.println("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.");
        System.out.println("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
        return Console.readLine();
    }

}
