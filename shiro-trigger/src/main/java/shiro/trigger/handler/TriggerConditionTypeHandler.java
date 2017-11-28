package shiro.trigger.handler;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import shiro.trigger.TriggerCondition;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TriggerConditionTypeHandler implements TypeHandler<TriggerCondition> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, TriggerCondition triggerCondition, JdbcType jdbcType) throws SQLException {
        if (triggerCondition != null) {
            String text = JSONObject.toJSONString(triggerCondition);
            preparedStatement.setString(i, text);
        } else
            preparedStatement.setString(i, null);
    }

    @Override
    public TriggerCondition getResult(ResultSet resultSet, String s) throws SQLException {
        String text = resultSet.getString(s);
        return JSONObject.parseObject(text, TriggerCondition.class);
    }

    @Override
    public TriggerCondition getResult(ResultSet resultSet, int i) throws SQLException {
        String text = resultSet.getString(i);
        return JSONObject.parseObject(text, TriggerCondition.class);
    }

    @Override
    public TriggerCondition getResult(CallableStatement callableStatement, int i) throws SQLException {
        String text = callableStatement.getString(i);
        return JSONObject.parseObject(text, TriggerCondition.class);
    }
}
