package shiro.trigger;

import java.util.List;
import java.util.Map;

public interface TriggerMapper {

    List<Trigger> queryAllTrigger(Map<String, Object> param);

    void insertTrigger(Trigger trigger);
}
