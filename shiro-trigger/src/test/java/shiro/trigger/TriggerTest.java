package shiro.trigger;

import org.junit.Test;

import javax.xml.ws.WebEndpoint;
import java.net.HttpURLConnection;
import java.net.URL;

public class TriggerTest {

    public String jobName = "任务名";
    public String triggerName = "触发器名";
    public String jobGroupName = "任务组名";
    public String triggerGroupName = "触发器组名";

    @Test
    public void testTrigger() throws InterruptedException {
        // QuartzManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, MyJob_1.class, "0/1 * * * * ?");
        Thread.sleep(5000);
    }

    @Test
    public void testTriggerForWebhook() throws InterruptedException {
        // QuartzManager.addJob(jobName, jobGroupName, triggerName, triggerGroupName, Webhook.class, "0/5 * * * * ?");
        Thread.sleep(20000);
    }

    @Test
    public void sendMsg() {
        try {
            String msg ="{\"msgtype\": \"text\",\"text\": {\"content\": \"大家好！我是 机器人，很高兴为你们服务。\"}}";
            URL url = new URL("https://oapi.dingtalk.com/robot/send?access_token=113d15b7d7969bd30435a6a9531f191d4908e34944eac32cc81e6aaa603077ff");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/json; charset=utf-8");
            conn.connect();
            conn.getOutputStream().write(msg.getBytes());
            conn.getOutputStream().flush();
            conn.getOutputStream().close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
