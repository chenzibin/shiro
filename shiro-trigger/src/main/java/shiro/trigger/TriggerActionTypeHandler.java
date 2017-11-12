package shiro.trigger;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * TriggerActionList <------> JSON
 */
public class TriggerActionTypeHandler implements TypeHandler<List<TriggerAction>> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, List<TriggerAction> actions, JdbcType jdbcType) throws SQLException {
        if (actions != null) {
            String text = JSONObject.toJSONString(actions);
            preparedStatement.setString(i, text);
        } else
            preparedStatement.setString(i, null);
    }

    @Override
    public List<TriggerAction> getResult(ResultSet resultSet, String columnLabel) throws SQLException {
        String text = resultSet.getString(columnLabel);
        return JSONObject.parseArray(text, TriggerAction.class);
    }

    @Override
    public List<TriggerAction> getResult(ResultSet resultSet, int i) throws SQLException {
        String text = resultSet.getString(i);
        return JSONObject.parseArray(text, TriggerAction.class);
    }

    @Override
    public List<TriggerAction> getResult(CallableStatement callableStatement, int i) throws SQLException {
        String text = callableStatement.getString(i);
        return JSONObject.parseArray(text, TriggerAction.class);
    }
}
