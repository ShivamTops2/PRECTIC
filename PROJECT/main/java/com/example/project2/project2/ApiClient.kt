package com.example.project2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient
{
    companion object
    {
        var retrofit: Retrofit? = null
        var myurl="https://topste.000webhostapp.com/API/"

        fun getapiclient() :Retrofit
        {
            if(retrofit==null)
            {
                retrofit= Retrofit.Builder()
                    .baseUrl(myurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!
        }
    }

}
