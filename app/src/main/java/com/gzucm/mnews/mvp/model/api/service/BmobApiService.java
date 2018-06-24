package com.gzucm.mnews.mvp.model.api.service;

import com.gzucm.mnews.mvp.model.entity.BmobEntity.User;
import com.gzucm.mnews.mvp.model.entity.UserEntity;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created on 2018/6/22 0022 23:59.
 *
 * @author herozii
 */
public interface BmobApiService {

    /**
     * /1/users	POST	用户注册、使用手机号注册登录、第三方注册登录
     * /1/login	GET	登录
     * /1/users/objectId	GET	获取当前用户、查询用户
     * /1/users/objectId	PUT	更新用户、第三方连接及断开连接
     * /1/users/objectId	DELETE	删除用户
     * /1/requestPasswordReset	POST	密码重置
     * /1/resetPasswordBySmsCode/smsCode	PUT	短信密码重置
     * /1/updateUserPassword/objectId	POST	旧密码更新密码
     * /1/requestEmailVerify
     */

    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65", "Content-Type:application/json","Accept: application/json"})
    @POST("users")
    Observable<UserEntity> registerByAccount(@Body User user);

    @FormUrlEncoded
    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65", "Content-Type:application/json"})
    @POST("https://api.bmob.cn/1/users")
    Observable<UserEntity> registerBySMSCode(@Field("mobilePhoneNumber") String userName, @Field("smsCode") String password);

    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65", "Content-Type:application/json"})
    @GET("login")
    Observable<UserEntity> loginByAccount(@Query("username") String username, @Query("password") String password);

    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65"})
    @GET("https://api.bmob.cn/1/login")
    Observable<UserEntity> loginBySMSCode(@Query("mobilePhoneNumber") String mobilePhoneNumber, @Query("smsCode") String smsCode);

    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65"})
    @GET("https://api.bmob.cn/1/users/{id}")
    Observable<UserEntity> getAccount(@Path("id") String id);

    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65"})
    @GET("https://api.bmob.cn/1/checkSession/{id}")
    Observable<String> checkToken(@Header("X-Bmob-Session-Token") String token, @Path("id") String id);

    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65", "Content-Type:application/json"})
    @PUT("https://api.bmob.cn/1/users/{id}")
    Observable<UserEntity> modifyAccount(@Header("X-Bmob-Session-Token") String token,@Path("id") String id,@Body User user);

    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65", "Content-Type:application/json"})
    @PUT("https://api.bmob.cn/1/users/{id}")
    Observable<UserEntity> resetPasswordByOld(@Header("X-Bmob-Session-Token") String token,@Path("id") String id,@Field("oldPassword") String oldPassword, @Field("newPassword") String newPassword);

//    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65", "Content-Type:application/json"})
//    @PUT("https://api.bmob.cn/1/users/{id}")
//    Observable<UserEntity> resetPasswordBySMSCode(@Header("X-Bmob-Session-Token") String token,@Path("id") String id,@Field("oldPassword") String oldPassword, @Field("newPassword") String newPassword);

    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65"})
    @DELETE("https://api.bmob.cn/1/users/{id}")
    Observable<UserEntity> deleteAccount(@Header("X-Bmob-Session-Token") String token,@Path("id") String id);
}
