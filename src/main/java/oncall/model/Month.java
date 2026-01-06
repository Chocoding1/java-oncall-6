package oncall.model;

public enum Month {
    JAN(1, 31),
    FEB(2, 28),
    MAR(3, 31),
    APR(4, 30),
    MAY(5, 31),
    JUN(6, 30),
    JUL(7, 31),
    AUG(8, 31),
    SEP(9, 30),
    OCT(10, 31),
    NOV(11, 30),
    DEC(12, 31),
    ;

    private final int monthOfYear;
    private final int daysOfMonth;

    Month(int monthOfYear, int daysOfMonth) {
        this.monthOfYear = monthOfYear;
        this.daysOfMonth = daysOfMonth;
    }

    public static Month from(int monthOfYear) {
        for (Month month : values()) {
            if (month.monthOfYear == monthOfYear) {
                return month;
            }
        }
        throw new IllegalArgumentException("[ERROR] 월은 1부터 12 사이의 숫자로 입력해 주세요.");
    }
}
