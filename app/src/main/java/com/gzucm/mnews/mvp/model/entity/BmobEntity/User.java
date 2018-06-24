package com.gzucm.mnews.mvp.model.entity.BmobEntity;

/**
 * Created on 2018/6/23 0023 0:01.
 *
 * @author herozii
 */
public class User {

    private String username;
    private String password;

    private String mobilePhoneNumber;

    public User(String username, String password, String mobilePhoneNumber) {
        this.username = username;
        this.password = password;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }



    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }
}
