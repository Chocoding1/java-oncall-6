package oncall.model;

public enum DayOfWeek {
    SUN("일", 0),
    MON("월", 1),
    TUE("화", 2),
    WED("수", 3),
    THU("목", 4),
    FRI("금", 5),
    SAT("토", 6),
    ;

    private final String name;
    private final int id;

    DayOfWeek(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static DayOfWeek from(String inputDayOfWeek) {
        for (DayOfWeek dayOfWeek : values()) {
            if (dayOfWeek.name.equals(inputDayOfWeek)) {
                return dayOfWeek;
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 요일입니다.");
    }
}
