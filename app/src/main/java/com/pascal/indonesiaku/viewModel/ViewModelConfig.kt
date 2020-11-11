package com.pascal.indonesiaku.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pascal.indonesiaku.model.batik.ResponseBatik
import com.pascal.indonesiaku.model.covid.ResponseCovid
import com.pascal.indonesiaku.model.daerah.ResponseDaerah
import com.pascal.indonesiaku.model.museum.ResponseMuseum
import com.pascal.indonesiaku.repo.Repository

class ViewModelConfig: ViewModel() {
    val repository = Repository()

    var responseGetDaerah = MutableLiveData<ResponseDaerah>()
    var responseGetBatik = MutableLiveData<ResponseBatik>()
    var responseGetCovid = MutableLiveData<ResponseCovid>()
    var responseGetMuseum = MutableLiveData<ResponseMuseum>()
    var isError = MutableLiveData<Throwable>()
    var isLoading = MutableLiveData<Boolean>()

    fun getDaerahView() {
        isLoading.value = true

        repository.getDaerah({
            isLoading.value = false
            responseGetDaerah.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }

    fun getBatikView() {
        isLoading.value = true

        repository.getBatik({
            isLoading.value = false
            responseGetBatik.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }

    fun getCovidView() {
        isLoading.value = true

        repository.getCovid({
            isLoading.value = false
            responseGetCovid.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }

    fun getMuseumView() {
        isLoading.value = true

        repository.getMuseum({
            isLoading.value = false
            responseGetMuseum.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }

    fun getMuseumByNameView(nama: String) {
        isLoading.value = true

        repository.getMuseumByName(nama, {
            isLoading.value = false
            responseGetMuseum.value = it
        },{
            isLoading.value = false
            isError.value = it
        })
    }

}