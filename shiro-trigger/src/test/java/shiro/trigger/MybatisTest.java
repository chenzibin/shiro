package shiro.trigger;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import shiro.trigger.Enum.TriggerActionType;
import shiro.trigger.Enum.TriggerEvent;
import shiro.trigger.Enum.TriggerState;
import shiro.trigger.Enum.TriggerType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MybatisTest {

    private TriggerMapper mapper = null;

    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        mapper = (TriggerMapper) context.getBean("triggerMapper");
    }

    @Test
    public void testQueryAllTrigger() {
        List<Trigger> triggers = mapper.queryAllTrigger();

        System.out.println(triggers.size());

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
        action.setWebhook("https://oapi.dingtalk.com/robot/send?access_token=113d15b7d7969bd30435a6a9531f191d4908e34944eac32cc81e6aaa603077ff");
        action.setText("触发器测试");
        actions.add(action);
        trigger.setActions(actions);
        mapper.insertTrigger(trigger);
    }

    @Test
    public void testEnum() {
        System.out.println(TriggerEnum.Type.CHECK.name());
    }
}
