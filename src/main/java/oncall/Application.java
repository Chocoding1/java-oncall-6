package oncall;

import oncall.config.AppConfig;
import oncall.controller.ScheduleController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        ScheduleController scheduleController = appConfig.scheduleController();
        scheduleController.run();
    }
}
