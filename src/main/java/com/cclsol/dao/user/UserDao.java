package com.cclsol.dao.user;

import com.cclsol.pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface UserDao{
    public User getLoginUser(Connection connection,String userCode) throws Exception;
    public boolean registerUser(Connection connection,String userCode,String userPassword,String userName) throws Exception;
}
