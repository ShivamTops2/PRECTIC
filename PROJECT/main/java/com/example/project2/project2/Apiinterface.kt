package com.example.project2


import com.example.project2.project2.Category_Model
import retrofit2.Call
import retrofit2.http.*

interface Apiinterface
{
    @FormUrlEncoded
@POST("TEST%202/insert.php")
    fun insertdata(
        @Field("firstname") firstname: String?,
        @Field("lastname") lastname: String?,
        @Field("mobil") mobile: String?,
        @Field("email") email: String?,
        @Field("password") password: String?,

        ): Call<Void>

    @FormUrlEncoded
    @POST("TEST%202/login.php")
    fun logindata(  @Field("mobile") mobile: String?,  @Field("password") password: String?):Call<RegisterModel>


    @get:GET("TEST%202/dashboard.php")
    val viewdata: Call<List<Dashboard_Model?>?>?

    @get:GET("TEST%202/category.php")
    val viewcategory_diwali: Call<List<Category_Model?>?>?


    @get:GET("TEST%202/category2.php")
    val viewcategory_holi: Call<List<Category_Model?>?>?

    @get:GET("TEST%202/category3.php")
    val viewcategory_ganeshchartuthi: Call<List<Category_Model?>?>?



}