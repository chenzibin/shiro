package shiro.trigger;

import java.util.List;

public interface TriggerMapper {

    List<Trigger> queryAllTrigger();

    void insertTrigger(Trigger trigger);
}
