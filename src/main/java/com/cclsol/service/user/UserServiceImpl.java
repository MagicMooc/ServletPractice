package com.cclsol.service.user;

import com.cclsol.dao.BaseDao;
import com.cclsol.dao.user.UserDao;
import com.cclsol.dao.user.UserDaoImpl;
import com.cclsol.pojo.User;

import java.sql.Connection;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();
    }

    @Override
    public User login(String userCode, String password) {
        Connection connection = null;
        User user = null;
        try{
            connection = BaseDao.getConnection();
            user=userDao.getLoginUser(connection,userCode);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        if(user != null){
            if(!user.getUserPassword().equals(password)){
                user = null;
            }
        }
        return user;
    }

    @Override
    public boolean register(String userCode, String userPassword, String userName) {
        Connection connection = null;
        boolean flag = true;
        try{
            connection = BaseDao.getConnection();
            flag = userDao.registerUser(connection,userCode,userPassword,userName);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }
}
