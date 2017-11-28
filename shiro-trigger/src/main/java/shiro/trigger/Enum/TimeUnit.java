package shiro.trigger.Enum;

public enum TimeUnit {
    SECOND("小时"),
    MINUTE("分"),
    HOUR("小时"),
    DAY("天");

    private String desc;

    TimeUnit(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
