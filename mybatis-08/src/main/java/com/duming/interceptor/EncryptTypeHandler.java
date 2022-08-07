package com.duming.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EncryptTypeHandler extends BaseTypeHandler {


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        String value = String.valueOf(o);
        if (StringUtils.isBlank(value)) {
            System.out.println("字段为空，不加密");
        } else {
            try {
                preparedStatement.setString(i, encode(value));
            } catch (Exception e) {
                System.out.println("index:{}, 加密失败");
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return decode(resultSet.getString(s), "resultSet.getString(i)" + s);
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return decode(resultSet.getString(i), "resultSet.getString(i)" + i);
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return decode(callableStatement.getString(i), "callableStatement.getString(i)" + i);
    }

    private String encode(String value) {
        //模拟加密
        value="ddmm"+value;
        return value;
    }

    private String decode(String value, String sign) {
        try {
            value = value.substring(4);
            System.out.println("解密成功。。。。"+value);
            return value;
        } catch (Exception e) {
            System.out.println("{}, 解密失败");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

