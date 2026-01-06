package oncall.model;

import java.util.List;

public class OncallInfo {

    private final Month month;
    private final DayOfWeek dayOfWeek;

    public OncallInfo(List<String> input) {
        validateInputSize(input);
        this.month = getValidatedMonth(input.get(0));
        this.dayOfWeek = getDayOfWeek(input.get(1));
    }

    public Month getMonth() {
        return month;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    private void validateInputSize(List<String> input) {
        if (input.size() != 2) {
            throw new IllegalArgumentException("[ERROR] 월과 시작 요일이 올바른 형식으로 입력되지 않았습니다.");
        }
    }

    private Month getValidatedMonth(String inputMonth) {
        int monthOfYear;
        try {
            monthOfYear = Integer.parseInt(inputMonth);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 월은 숫자로 입력해 주세요.");
        }

        return Month.from(monthOfYear);
    }

    private DayOfWeek getDayOfWeek(String inputDayOfWeek) {
        return DayOfWeek.from(inputDayOfWeek);
    }
}
