package shiro.trigger;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import java.net.HttpURLConnection;
import java.net.URL;


public class Webhook implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
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
