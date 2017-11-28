package quartz;

import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;

public class HelloTest {

    @Test
    public void testSimpleTrigger() throws SchedulerException {

        JobDetail job = JobBuilder.newJob(HelloJob.class).withIdentity("jobName", "group").build();

        Trigger trigger = HelloTrigger.getSimpleTrigger();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();

        scheduler.start();

        scheduler.scheduleJob(job, trigger);

        scheduler.shutdown(true);
    }
}
