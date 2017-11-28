package shiro.trigger.Enum;

public enum TimeStrategyType {
    DAILY("daily", "每天"),
    WEEKLY("weekly", "每周"),
    MONTHLY("monthly", "每月"),
    CYCLE("cycle", "周期"),
    SINGLE("single", "单次");

    private String value;
    private String desc;

    TimeStrategyType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
