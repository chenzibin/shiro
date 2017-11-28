package shiro.trigger;

import java.util.Date;
import java.util.List;

/**
 * 触发器
 */
public class Trigger {
    /*id*/
    private String id;
    /*触发器名*/
    private String name;
    /*触发器描述*/
    private String desc;
    /*触发器类型*/
    private String type;
    /*触发事件*/
    private String event;
    /*触发器状态  0:关闭 1:开启*/
    private String state;
    /*执行动作*/
    private List<TriggerAction> actions;
    /*触发条件*/
    private TriggerCondition condition;
    /*定时时间策略*/
    private TimeStrategy timeStrategy;
    /*是否延时*/
    private Boolean delay;
    /*延时时间*/
    private Integer delayTime;
    /*延时时间单位*/
    private String delayUnit;
    private String createTime;

    public String getCreateTime() {
        if (createTime != null) {
            createTime = createTime.split(".")[0];
        }
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<TriggerAction> getActions() {
        return actions;
    }

    public void setActions(List<TriggerAction> actions) {
        this.actions = actions;
    }

    public TriggerCondition getCondition() {
        return condition;
    }

    public void setCondition(TriggerCondition condition) {
        this.condition = condition;
    }

    public TimeStrategy getTimeStrategy() {
        return timeStrategy;
    }

    public void setTimeStrategy(TimeStrategy timeStrategy) {
        this.timeStrategy = timeStrategy;
    }

    public Boolean getDelay() {
        return delay;
    }

    public void setDelay(Boolean delay) {
        this.delay = delay;
    }

    public Integer getDelayTime() {
        return delayTime;
    }

    public void setDelayTime(Integer delayTime) {
        this.delayTime = delayTime;
    }

    public String getDelayUnit() {
        return delayUnit;
    }

    public void setDelayUnit(String delayUnit) {
        this.delayUnit = delayUnit;
    }
}
