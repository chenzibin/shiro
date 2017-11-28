package shiro.trigger;

/**
 * 触发器动作
 */
public class TriggerAction {

    /*动作类型*/
    private String type;
    /*是否可用*/
    private boolean enable;

    private String[] acceptor;

    private String webhook;

    private String text;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getWebhook() {
        return webhook;
    }

    public void setWebhook(String webhook) {
        this.webhook = webhook;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String[] acceptor) {
        this.acceptor = acceptor;
    }
}
