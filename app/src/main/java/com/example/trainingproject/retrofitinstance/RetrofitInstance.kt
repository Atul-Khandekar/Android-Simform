package com.example.trainingproject.retrofitinstance

import android.content.Context
import com.example.trainingproject.apiservices.LoginService
import com.example.trainingproject.apiservices.ProfileScreenService
import com.example.trainingproject.apiservices.RegisterService
import com.example.trainingproject.apiservices.ShoppingListService
import com.example.trainingproject.apiservices.UserListService
import com.example.trainingproject.constants.Constants
import com.example.trainingproject.interceptors.AuthInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance(context: Context) {

    private fun getHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    val getLoginApi: LoginService by lazy {
        Retrofit.Builder().baseUrl(Constants.RESTAPI_BASE_URL).client(getHttpClient())
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(LoginService::class.java)
    }

    val getUserListApi: UserListService by lazy {
        Retrofit.Builder().baseUrl(Constants.REQRES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(UserListService::class.java)
    }

    val getRegisterApi: RegisterService by lazy {
        Retrofit.Builder().baseUrl(Constants.RESTAPI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(okhttpClient(context))
            .build().create(RegisterService::class.java)
    }

    val getUserProfile: ProfileScreenService by lazy {
        Retrofit.Builder().baseUrl(Constants.RESTAPI_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(okhttpClient(context))
            .build().create(ProfileScreenService::class.java)
    }

    val getShoppingList: ShoppingListService by lazy {
        Retrofit.Builder().baseUrl(Constants.SHOPKART_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ShoppingListService::class.java)
    }

    private fun okhttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(AuthInterceptor(context)).build()
    }
}