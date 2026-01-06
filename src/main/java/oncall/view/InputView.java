package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_ONCALL_INFO_NOTICE = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String READ_WEEKDAYS_ONCALL_EMPLOYEES_NOTICE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";

    public String readOncallInfo() {
        System.out.print(READ_ONCALL_INFO_NOTICE);
        return Console.readLine();
    }

    public String readWeekdaysOncallNicknames() {
        System.out.println(READ_WEEKDAYS_ONCALL_EMPLOYEES_NOTICE);
        return Console.readLine();
    }
}
