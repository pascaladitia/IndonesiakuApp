package com.pascal.indonesiaku.network

import com.pascal.indonesiaku.model.batik.ResponseBatik
import com.pascal.indonesiaku.model.covid.ResponseCovid
import com.pascal.indonesiaku.model.daerah.ResponseDaerah
import com.pascal.indonesiaku.model.museum.ResponseMuseum
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ConfigService {

    @GET("MeP7c5ne5ZZHvtG7IvXmVDSCLTB73gd1XwqFjaWUiiTZrz1exj8pLIbFFm/m/wilayah/provinsi")
    fun getDaerah(): Flowable<ResponseDaerah>

    @GET("index.php/batik/all")
    fun getBatik(): Flowable<ResponseBatik>

    @GET("api/provinsi/")
    fun getCovid(): Flowable<ResponseCovid>

    @GET("api/index.php/CcariMuseum/searchGET?nama=museum")
    fun getMuseum(): Flowable<ResponseMuseum>

    @GET("api/index.php/CcariMuseum/searchGET?nama=")
    fun getMuseumByName(@Query("nama") nama: String): Flowable<ResponseMuseum>
}