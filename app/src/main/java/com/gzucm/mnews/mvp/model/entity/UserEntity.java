package com.gzucm.mnews.mvp.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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

    /**
     * 查询所有用户
     */
    private List<ResultsBean> results;


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

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * createdAt : 2018-06-24 14:44:30
         * email : 1456807058@qq.com
         * emailVerified : false
         * mobilePhoneNumber : 13226626022
         * objectId : 9a47058c72
         * updatedAt : 2018-06-27 10:44:10
         * username : hrx
         */

        @SerializedName("createdAt")
        private String createdAtX;
        private String email;
        private boolean emailVerified;
        @SerializedName("mobilePhoneNumber")
        private String mobilePhoneNumberX;
        @SerializedName("objectId")
        private String objectIdX;
        @SerializedName("updatedAt")
        private String updatedAtX;
        @SerializedName("username")
        private String usernameX;

        public String getCreatedAtX() {
            return createdAtX;
        }

        public void setCreatedAtX(String createdAtX) {
            this.createdAtX = createdAtX;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isEmailVerified() {
            return emailVerified;
        }

        public void setEmailVerified(boolean emailVerified) {
            this.emailVerified = emailVerified;
        }

        public String getMobilePhoneNumberX() {
            return mobilePhoneNumberX;
        }

        public void setMobilePhoneNumberX(String mobilePhoneNumberX) {
            this.mobilePhoneNumberX = mobilePhoneNumberX;
        }

        public String getObjectIdX() {
            return objectIdX;
        }

        public void setObjectIdX(String objectIdX) {
            this.objectIdX = objectIdX;
        }

        public String getUpdatedAtX() {
            return updatedAtX;
        }

        public void setUpdatedAtX(String updatedAtX) {
            this.updatedAtX = updatedAtX;
        }

        public String getUsernameX() {
            return usernameX;
        }

        public void setUsernameX(String usernameX) {
            this.usernameX = usernameX;
        }
    }
}
