package com.pascal.indonesiaku.model.covid

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseCovid(

	@field:SerializedName("data")
	val data: List<CovidItem?>? = null
) : Parcelable

@Parcelize
data class CovidItem(

	@field:SerializedName("fid")
	val fid: Int? = null,

	@field:SerializedName("provinsi")
	val provinsi: String? = null,

	@field:SerializedName("kasusMeni")
	val kasusMeni: Int? = null,

	@field:SerializedName("kodeProvi")
	val kodeProvi: Int? = null,

	@field:SerializedName("kasusSemb")
	val kasusSemb: Int? = null,

	@field:SerializedName("kasusPosi")
	val kasusPosi: Int? = null
) : Parcelable
