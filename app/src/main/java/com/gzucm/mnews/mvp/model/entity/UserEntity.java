package com.gzucm.mnews.mvp.model.entity;

/**
 * Created on 2018/6/23 0023 0:15.
 *
 * @author herozii
 */
public class UserEntity{

    /**
     * 注册成功201
     * createdAt : 2018-06-22 23:55:00
     * objectId : b96e5ebb81
     * sessionToken : 565b2b5d400fbbc7802fd128a193ff82
     */
    private String createdAt;
    private String objectId;
    private String sessionToken;
    /**
     * 已经注册了
     * code : 202
     * error : username 'wgz' already taken.
     */
    private int code;
    private String error;
    /**
     * 使用手机注册
     * "username": "185xxxxxxxx",
     * "mobilePhoneNumber": "185xxxxxxxx",
     * "mobilePhoneVerified": true,
     * "createdAt": "2011-11-07 20:58:34",
     * "updatedAt": "2011-11-07 20:58:34",
     * "objectId": "Kc3M222J",
     * "sessionToken": "pnktnjyb996sj4p156gjtp4im"
     */

    private String username;
    private String mobilePhoneNumber;
    private boolean mobilePhoneVerified;
    private String updatedAt;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public boolean isMobilePhoneVerified() {
        return mobilePhoneVerified;
    }

    public void setMobilePhoneVerified(boolean mobilePhoneVerified) {
        this.mobilePhoneVerified = mobilePhoneVerified;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
