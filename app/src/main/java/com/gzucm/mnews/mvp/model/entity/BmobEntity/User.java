package com.gzucm.mnews.mvp.model.entity.BmobEntity;

import cn.bmob.v3.BmobUser;

/**
 * Created on 2018/6/23 0023 0:01.
 *
 * @author herozii
 */
public class User extends BmobUser{

    private String username;
    private String password;
    private String email;
    private String mobilePhoneNumber;

    public User(String username, String password, String email, String mobilePhoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    @Override
    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }
}
