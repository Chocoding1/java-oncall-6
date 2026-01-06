package oncall.util;

import java.util.Arrays;
import java.util.List;

public class CommaParser {

    private static final String COMMA = ",";

    public static List<String> parse(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백은 입력할 수 없습니다.");
        }
        return Arrays.stream(input.split(COMMA)).toList();
    }
}
