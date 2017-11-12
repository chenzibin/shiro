package shiro.trigger;

import com.dingtalk.chatbot.DingtalkChatbotClient;
import com.dingtalk.chatbot.SendResult;
import com.dingtalk.chatbot.message.TextMessage;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by dustin on 2017/3/18.
 */
public class TextMessageTest {

    private DingtalkChatbotClient client = new DingtalkChatbotClient();

    @Test
    public void testSendTextMessage() throws Exception {
        TextMessage message = new TextMessage("大家好！我是 煞笔 机器人，很高兴为你们服务。");
        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

    @Test
    public void testSendTextMessageWithAt() throws Exception {
        TextMessage message = new TextMessage("大家好！我是 煞笔 机器人，很高兴为你们服务。");
        ArrayList<String> atMobiles = new ArrayList<String>();
        atMobiles.add("15869338705");
        atMobiles.add("18059024428");
        message.setAtMobiles(atMobiles);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

    @Test
    public void testSendTextMessageWithAtAll() throws Exception {
        TextMessage message = new TextMessage("大家好！我是 煞笔 机器人，很高兴为你们服务。");
        message.setIsAtAll(true);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }

    @Test
    public void testSendTextMessageWithAtAndAtAll() throws Exception {
        TextMessage message = new TextMessage("大家好！我是 煞笔 机器人，很高兴为你们服务。");
        ArrayList<String> atMobiles = new ArrayList<String>();
        atMobiles.add("186xxxx0822");
        message.setAtMobiles(atMobiles);
        message.setIsAtAll(true);

        SendResult result = client.send(TestConfig.CHATBOT_WEBHOOK, message);
        System.out.println(result);
    }
}