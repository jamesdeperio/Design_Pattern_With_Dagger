package io.github.jamesdeperio.architecture.integration.network

import io.github.jamesdeperio.architecture.global.model.temp.login.LoginRequest
import io.reactivex.Observable
import jdp.retrofitkit.JSONFormat
import retrofit2.http.GET
import retrofit2.http.Query

interface RestRepository {
    //@POST()
    @GET("5c0798af3000007700d25b8e")  //mocky.io success response //i've used GET just for testing
    @JSONFormat
    fun loginRequest(
            //@Field("username")
            @Query("username")username:String,
            //@Field("password")
            @Query("password")password:String
    ):Observable<LoginRequest>

    //@POST()
    @GET("5c11ad1b3300005300998bac")  //mocky.io failed response //i've used GET just for testing
    @JSONFormat
    fun loginRequestError(
            //@Field("username")
            @Query("username")username:String,
            //@Field("password")
            @Query("password")password:String
    ):Observable<LoginRequest>
}