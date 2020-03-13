package org.linlinjava.litemall.db.mybatis;

import java.sql.CallableStatement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonMapTypeHandler extends BaseTypeHandler<Map<String,Object>> {
    private static final ObjectMapper mapper = new ObjectMapper();
    private final Logger logger = LoggerFactory.getLogger(JsonMapTypeHandler.class);

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Map<String,Object> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, toJson(parameter));
    }

    @Override
    public Map<String,Object> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return this.toObject(rs.getString(columnName));
    }

    @Override
    public Map<String,Object> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return this.toObject(rs.getString(columnIndex));
    }

    @Override
    public Map<String,Object> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return this.toObject(cs.getString(columnIndex));
    }

    private String toJson(Map<String,Object> params) {
        try {
            return mapper.writeValueAsString(params);
        } catch (Exception e) {
        	logger.error("",e);
        }
        return "[]";
    }

    private Map<String,Object> toObject(String content) {
        if (content != null && !content.isEmpty()) {
            try {
                return (Map<String,Object>) mapper.readValue(content, Map.class);
            } catch (Exception e) {
            	logger.error("",e);
                throw new RuntimeException(e);
            }
        } else {
            return null;
        }
    }
}