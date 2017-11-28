package quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

public class HelloTrigger {

    public static Trigger getSimpleTrigger() {
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("triggerName", "group")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever()
                )
                .build();
        return trigger;
    }

    public static Trigger getCronTrigger() {
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("triggerName", "group")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/5 * * * * ?")
                )
                .build();
        return trigger;
    }
}
