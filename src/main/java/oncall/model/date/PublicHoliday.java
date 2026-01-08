package oncall.model.date;

public enum PublicHoliday {
    NEW_YEAR(Month.JAN, 1),
    INDEPENDENCE_MOVEMENT(Month.MAR, 1),
    CHILDREN(Month.MAY, 5),
    MEMORIAL(Month.JUN, 6),
    LIBERATION(Month.AUG, 15),
    NATIONAL_FOUNDATION(Month.OCT, 3),
    HANGUL(Month.OCT, 9),
    CHRISTMAS(Month.DEC, 25),
    ;

    private final Month month;
    private final int date;

    PublicHoliday(Month month, int date) {
        this.month = month;
        this.date = date;
    }

    public static boolean isHoliday(Month month, int date) {
        for (PublicHoliday publicHoliday : values()) {
            if (publicHoliday.month == month && publicHoliday.date == date) {
                return true;
            }
        }
        return false;
    }
}
