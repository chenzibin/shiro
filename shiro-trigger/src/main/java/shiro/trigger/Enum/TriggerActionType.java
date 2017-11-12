package shiro.trigger.Enum;

public enum TriggerActionType {
    SMS("发送短信给用户"),
    MAIL("发送邮件给用户"),
    DINGTALK("发送钉钉给用户");

    private String desc;

    TriggerActionType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
