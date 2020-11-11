package com.pascal.indonesiaku.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ConfigNetwork {

    companion object {
        fun daerahNetwork(): ConfigService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://x.rajaapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            val service = retrofit.create(ConfigService::class.java)
            return service
        }

        fun batikNetwork(): ConfigService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://batikita.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            val service = retrofit.create(ConfigService::class.java)
            return service
        }

        fun covidNetwork(): ConfigService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://indonesia-covid-19.mathdro.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            val service = retrofit.create(ConfigService::class.java)
            return service
        }

        fun museumNetwork(): ConfigService {
            val retrofit = Retrofit.Builder()
                .baseUrl("http://jendela.data.kemdikbud.go.id/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build()

            val service = retrofit.create(ConfigService::class.java)
            return service
        }
    }
}