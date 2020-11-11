package com.pascal.indonesiaku.repo

import com.pascal.indonesiaku.model.batik.ResponseBatik
import com.pascal.indonesiaku.model.covid.ResponseCovid
import com.pascal.indonesiaku.model.daerah.ResponseDaerah
import com.pascal.indonesiaku.model.museum.ResponseMuseum
import com.pascal.indonesiaku.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class Repository {

    fun getDaerah(responHandler: (ResponseDaerah) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.daerahNetwork().getDaerah().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun getBatik(responHandler: (ResponseBatik) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.batikNetwork().getBatik().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun getCovid(responHandler: (ResponseCovid) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.covidNetwork().getCovid().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun getMuseum(responHandler: (ResponseMuseum) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.museumNetwork().getMuseum().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }

    fun getMuseumByName(name: String, responHandler: (ResponseMuseum) -> Unit, errorHandler: (Throwable) -> Unit) {
        ConfigNetwork.museumNetwork().getMuseumByName(name).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responHandler(it)
            }, {
                errorHandler(it)
            })
    }
}