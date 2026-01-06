package oncall.model;

import java.util.List;

public class OncallInfo {

    private final int month;
    private final DayOfWeek dayOfWeek;

    public OncallInfo(List<String> input) {
        validateInputSize(input);
        this.month = getValidatedMonth(input.get(0));
        this.dayOfWeek = getDayOfWeek(input.get(1));
    }

    private void validateInputSize(List<String> input) {
        if (input.size() != 2) {
            throw new IllegalArgumentException("[ERROR] 월과 시작 요일이 올바른 형식으로 입력되지 않았습니다.");
        }
    }

    private int getValidatedMonth(String inputMonth) {
        int month;
        try {
            month = Integer.parseInt(inputMonth);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 월은 숫자로 입력해 주세요.");
        }

        if (month < 1 || 12 < month) {
            throw new IllegalArgumentException("[ERROR] 월은 1부터 12 사이의 숫자로 입력해 주세요.");
        }

        return month;
    }

    private DayOfWeek getDayOfWeek(String inputDayOfWeek) {
        return DayOfWeek.from(inputDayOfWeek);
    }
}
