package shiro.trigger.Job;

import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.TextMessage;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import shiro.trigger.Enum.TriggerActionType;
import shiro.trigger.Trigger;
import shiro.trigger.TriggerAction;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CheckReturnVisit implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("checkReturnVisit");
        Trigger trigger = (Trigger) jobExecutionContext.getJobDetail().getJobDataMap().get("trigger");
        List<TriggerAction> actions = trigger.getActions();
        for (TriggerAction action : actions) {
            if (TriggerActionType.DINGTALK.name().equals(action.getType())) {
                TextMessage message = new TextMessage(action.getText());
                message.setAtMobiles(Arrays.asList("18059024427"));
                try {
                    SendResult result = new DingtalkChatbotClient().send(action.getWebhook(), message);
                    System.out.println(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}