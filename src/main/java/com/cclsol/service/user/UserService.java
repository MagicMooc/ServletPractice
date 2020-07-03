package com.cclsol.service.user;

import com.cclsol.pojo.User;

public interface UserService {
    public User login(String userCode, String password);
    public boolean register(String userCode,String userPassword,String userName);
}
