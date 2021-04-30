package com.plete.latihanpi

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @GET("penggguna/QuranJSON/master/quran.json")
    fun getAPI(): Call<ArrayList<ApiModel>>
}