package shiro.trigger.Enum;

import shiro.trigger.Job.CheckReturnVisit;

public enum TriggerEvent {
    CHECK_RETURN_VISIT("回访记录", CheckReturnVisit.class);

    private String desc;
    private Class clazz;

    TriggerEvent(String desc, Class clazz) {
        this.desc = desc;
        this.clazz = clazz;
    }

    public String getDesc() {
        return desc;
    }

    public Class getClazz() {
        return clazz;
    }
}
