package shiro.trigger;

import java.util.List;

public class TriggerCondition {

    private String when;

    private List<ConditionExpression> conditionExpressions;

    private List<TriggerCondition> nestingConditions;

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public List<ConditionExpression> getConditionExpressions() {
        return conditionExpressions;
    }

    public void setConditionExpressions(List<ConditionExpression> conditionExpressions) {
        this.conditionExpressions = conditionExpressions;
    }

    public List<TriggerCondition> getNestingConditions() {
        return nestingConditions;
    }

    public void setNestingConditions(List<TriggerCondition> nestingConditions) {
        this.nestingConditions = nestingConditions;
    }
}
