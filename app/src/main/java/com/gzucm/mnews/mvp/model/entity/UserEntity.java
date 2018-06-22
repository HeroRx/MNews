package com.gzucm.mnews.mvp.model.entity;

/**
 * Created on 2018/6/23 0023 0:15.
 *
 * @author herozii
 */
public class UserEntity {

    /**
     * createdAt : 2018-06-22 23:55:00
     * objectId : b96e5ebb81
     * sessionToken : 565b2b5d400fbbc7802fd128a193ff82
     */

    private String createdAt;
    private String objectId;
    private String sessionToken;

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
}
