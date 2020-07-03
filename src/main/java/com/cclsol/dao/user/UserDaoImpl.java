package com.cclsol.dao.user;

import com.cclsol.dao.BaseDao;
import com.cclsol.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public User getLoginUser(Connection connection, String userCode) throws Exception {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null) {
            String sql = "select * from User where userCode = ?";
            Object[] params = {userCode};
            resultSet = BaseDao.execute(connection, preparedStatement, resultSet, sql, params);
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserCode(resultSet.getString("userCode"));
                user.setUserName(resultSet.getString("userName"));
                user.setUserPassword(resultSet.getString("UserPassword"));
            }
            BaseDao.closeResource(null, preparedStatement, resultSet);
        }
        return user;
    }

    @Override
    public boolean registerUser(Connection connection, String userCode, String userPassword,String userName){
        boolean flag =true;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        User user = null;
        if (connection != null) {
            String sql = "insert into User(userCode, userName, userPassword) VALUES (?,?,?);";
            Object[] params = {userCode,userName,userPassword};

            try {
                BaseDao.execute(connection,preparedStatement,sql,params);
            } catch (SQLException throwables) {
                flag =false;
            }finally {
                BaseDao.closeResource(null,preparedStatement,null);
            }
        }
        return flag;
    }
}

