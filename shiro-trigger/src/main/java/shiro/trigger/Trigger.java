package shiro.trigger;

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
}
