package shiro.trigger;

public class TimeStrategy {

    /**
     * 描述
     */
    private String desc;

    /**
     * 策略类型
     *  枚举值: 1=每天，2=每周，3=每月，4=周期，5=单次
     */
    private String executeType;

    /**
     * 执行时间
     */
    private String executeTime;

    /**
     * 执行月份 (按月执行)
     */
    private String executeMonth;

    /**
     * 指定月份具体执行的天数，用于按月
     * @description 可以1个多个，多个用","分隔
     */
    private String executeDayOfMonth;

    /**
     *  一周执行的天数，用于按周
     *  @description 可以1个多个，多个用","分隔
     */
    private String executeDayOfWeek;

    /**
     * 间隔 (按周期执行)
     */
    private int timeInterval;

    /**
     *  间隔单位 (按周期执行)
     */
    private String intervalUnit;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getExecuteType() {
        return executeType;
    }

    public void setExecuteType(String executeType) {
        this.executeType = executeType;
    }

    public String getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(String executeTime) {
        this.executeTime = executeTime;
    }

    public String getExecuteMonth() {
        return executeMonth;
    }

    public void setExecuteMonth(String executeMonth) {
        this.executeMonth = executeMonth;
    }

    public String getExecuteDayOfMonth() {
        return executeDayOfMonth;
    }

    public void setExecuteDayOfMonth(String executeDayOfMonth) {
        this.executeDayOfMonth = executeDayOfMonth;
    }

    public String getExecuteDayOfWeek() {
        return executeDayOfWeek;
    }

    public void setExecuteDayOfWeek(String executeDayOfWeek) {
        this.executeDayOfWeek = executeDayOfWeek;
    }

    public int getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(int timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getIntervalUnit() {
        return intervalUnit;
    }

    public void setIntervalUnit(String intervalUnit) {
        this.intervalUnit = intervalUnit;
    }
}
