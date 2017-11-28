package shiro.trigger.handler;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import shiro.trigger.TimeStrategy;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TimeStrategyTypeHandler implements TypeHandler<TimeStrategy> {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, TimeStrategy timeStrategy, JdbcType jdbcType) throws SQLException {
        if (timeStrategy != null) {
            String text = JSONObject.toJSONString(timeStrategy);
            preparedStatement.setString(i, text);
        } else
            preparedStatement.setString(i, null);
    }

    @Override
    public TimeStrategy getResult(ResultSet resultSet, String s) throws SQLException {
        String text = resultSet.getString(s);
        return JSONObject.parseObject(text, TimeStrategy.class);
    }

    @Override
    public TimeStrategy getResult(ResultSet resultSet, int i) throws SQLException {
        String text = resultSet.getString(i);
        return JSONObject.parseObject(text, TimeStrategy.class);
    }

    @Override
    public TimeStrategy getResult(CallableStatement callableStatement, int i) throws SQLException {
        String text = callableStatement.getString(i);
        return JSONObject.parseObject(text, TimeStrategy.class);
    }
}
