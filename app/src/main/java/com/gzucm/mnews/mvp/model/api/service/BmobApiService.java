package com.gzucm.mnews.mvp.model.api.service;

import com.gzucm.mnews.mvp.model.entity.BmobEntity.User;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created on 2018/6/22 0022 23:59.
 *
 * @author herozii
 */
public interface BmobApiService {
    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65", "Content-Type:application/json"})
    @POST("https://api.bmob.cn/1/classes/_User")
    Observable<User> createAccount(@Body User user);

    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65"})
    @GET("https://api.bmob.cn/1/classes/_User/{id}")
    Observable<User> getAccount(@Path("id") String id);

    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65", "Content-Type:application/json"})
    @PUT("https://api.bmob.cn/1/classes/_User/{id}")
    Observable<User> modifyAccount(@Path("id") String id);

    @Headers({"X-Bmob-Application-Id:9c187271e2c2908a1281d35d99466c65", "X-Bmob-REST-API-Key:748f8c15e0a9c4767ab3bbadda223f65"})
    @DELETE("https://api.bmob.cn/1/classes/_User/{id}")
    Observable<User> deleteAccount(@Path("id") String id);
}
