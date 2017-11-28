package shiro.trigger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shiro.trigger.Enum.*;

import java.util.*;

public class MybatisTest {

    private TriggerMapper mapper = null;

    public String jobName = "任务名";
    public String triggerName = "触发器名";
    public String jobGroupName = "任务组名";
    public String triggerGroupName = "触发器组名";

    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        mapper = (TriggerMapper) context.getBean("triggerMapper");
    }

    @Test
    public void testQueryAllTrigger() throws InterruptedException {
        Map<String, Object> param = new HashMap<>();
        param.put("type", TriggerType.CHECK.name());
        List<Trigger> triggers = mapper.queryAllTrigger(param);
//
//        for (Trigger trigger : triggers) {
//            QuartzManager.addJob("Job_" + trigger.getEvent(), "JobGroup_" + trigger.getType(), "Trigger_" + trigger.getEvent(), "TriggerGroup_" + trigger.getType(),
//                    TriggerEvent.valueOf(trigger.getEvent()).getClazz(), "0/5 * * * * ?", trigger);
//        }

        Thread.sleep(1000 * 20);
    }

    @Test
    public void testInsertTrigger() {
        Trigger trigger = new Trigger();
        trigger.setId(UUID.randomUUID().toString().replace("-", ""));
        trigger.setName("触发器test1");
        trigger.setDesc("触发器desc");
        trigger.setType(TriggerType.CHECK.name());
        trigger.setEvent(TriggerEvent.CHECK_RETURN_VISIT.name());
        trigger.setState(TriggerState.ON.name());
        List<TriggerAction> actions = new ArrayList<>();
        TriggerAction action = new TriggerAction();
        action.setType(TriggerActionType.DINGTALK.name());
        action.setEnable(true);
        action.setAcceptor(new String[] {"super_admin", "chenzb"});
        //action.setWebhook("https://oapi.dingtalk.com/robot/send?access_token=113d15b7d7969bd30435a6a9531f191d4908e34944eac32cc81e6aaa603077ff");
        action.setWebhook("https://oapi.dingtalk.com/robot/send?access_token=0968e5e0218edd74164a62b48d94fdb5dd4e21bea3c3685d9f0bed9ac90cd4b0");
        action.setText("触发器测试");
        actions.add(action);
        trigger.setActions(actions);

//        TriggerCondition condition = new TriggerCondition();
//        condition.setWhen(TriggerConditionWhen.ALL.name());
//        ConditionExpression expression = new ConditionExpression();
//        expression.setKey("key1");
//        expression.setComparison();
//        condition.setConditionExpressions("");

        TimeStrategy timeStrategy = new TimeStrategy();
        timeStrategy.setExecuteType(TimeStrategyType.SINGLE.name());
        timeStrategy.setExecuteTime("2017-11-12 09:02:10");
        trigger.setTimeStrategy(timeStrategy);

        trigger.setDelay(false);
        trigger.setDelayTime(0);
        trigger.setDelayUnit(TimeUnit.MINUTE.name());
        mapper.insertTrigger(trigger);
    }

    @Test
    public void testEnum() {
        System.out.println(TriggerEnum.Type.CHECK.name());
    }

    @Test
    public void testTrigger() {

    }
}
