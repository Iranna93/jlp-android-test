package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName
import com.johnlewis.test.data.entities.productdetails.VideosList


data class Videos(

    @SerializedName("videosList") var videosList: ArrayList<VideosList> = arrayListOf(),
    @SerializedName("videoHost") var videoHost: String,
    @SerializedName("videoImagePath") var videoImagePath: String,
    @SerializedName("prod_vid_thmb") var prodVidThmb: String,
    @SerializedName("videoHeight") var videoHeight: String,
    @SerializedName("videoWidth") var videoWidth: String,
    @SerializedName("imgAltText") var imgAltText: String

)