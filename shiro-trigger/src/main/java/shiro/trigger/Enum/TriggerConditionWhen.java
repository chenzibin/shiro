package shiro.trigger.Enum;

public enum TriggerConditionWhen {

    ALL("全部满足"),
    ANY("任意满足"),
    NOT("全不满足");

    private String desc;

    TriggerConditionWhen(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
