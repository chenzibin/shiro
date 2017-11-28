package shiro.trigger;

import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.message.TextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import shiro.trigger.Enum.TriggerActionType;

import java.io.IOException;
import java.util.List;

public class TriggerActionHandler {

    @Autowired
    private TriggerMapper mapper;

    private DingtalkChatbotClient dingtalkChatbotClient = new DingtalkChatbotClient();

    private TriggerActionHandler instance;

    private TriggerActionHandler() {}

    public TriggerActionHandler getInstance() {
        if (instance == null) {
            instance = new TriggerActionHandler();
        }
        return instance;
    }

    public void handleActions(List<TriggerAction> actions) {
        if (actions == null || actions.size() == 0) {
            return;
        }
        for (TriggerAction action : actions) {
            handleAction(action);
        }
    }

    public void handleAction(TriggerAction action) {
        if (action == null || action.getType() == null || action.getType().trim().length() == 0) {
            return;
        }
        try {
            if (TriggerActionType.DINGTALK.name().equals(action.getType())) {
                handleActionOfDingTalk(action);
            } else if (TriggerActionType.MAIL.name().equals(action.getType())) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void handleActionOfDingTalk(TriggerAction action) throws IOException {
        TextMessage message = new TextMessage(action.getText());
        dingtalkChatbotClient.send(action.getWebhook(), message);
    }
}
