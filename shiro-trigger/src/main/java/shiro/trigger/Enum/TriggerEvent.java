package shiro.trigger.Enum;

public enum TriggerEvent {
    CHECK_RETURN_VISIT("回访记录");

    private String desc;

    TriggerEvent(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
