package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class DynamicAttributes(
    @SerializedName("noiselevelrating") var noiselevelrating: String,
    @SerializedName("timeremainingindicator") var timeremainingindicator: String,
    @SerializedName("weightedenergyconsumptionper100cyclesforecocycle") var weightedenergyconsumptionper100cyclesforecocycle: String,
    @SerializedName("integratedorfreestanding") var integratedorfreestanding: String,
    @SerializedName("cutlerybasket") var cutlerybasket: String,
    @SerializedName("dishwashersize") var dishwashersize: String,
    @SerializedName("saltlevelindicator") var saltlevelindicator: String,
    @SerializedName("floodprotection") var floodprotection: String,
    @SerializedName("dryingsystem") var dryingsystem: String,
    @SerializedName("automaticloadadjustment") var automaticloadadjustment: String,
    @SerializedName("noiselevel") var noiselevel: String,
    @SerializedName("digitaldisplay") var digitaldisplay: String,
    @SerializedName("delicatewash") var delicatewash: String,
    @SerializedName("quickwash") var quickwash: String,
    @SerializedName("homearea") var homearea: String,
    @SerializedName("energyratingoverall") var energyratingoverall: String,
    @SerializedName("onlineexclusive") var onlineexclusive: String,
    @SerializedName("childlock") var childlock: String,
    @SerializedName("timerdelay") var timerdelay: String,
    @SerializedName("dryingperformance") var dryingperformance: String,
    @SerializedName("homeappliancetype") var homeappliancetype: String,
    @SerializedName("cycledurationatratedcapacityfortheecocycle") var cycledurationatratedcapacityfortheecocycle: String,
    @SerializedName("programsequenceindicator") var programsequenceindicator: String,
    @SerializedName("adjustableracking") var adjustableracking: String,
    @SerializedName("homeappliancefeatures") var homeappliancefeatures: ArrayList<String> = arrayListOf(),
    @SerializedName("quietmark") var quietmark: String,
    @SerializedName("noofprograms") var noofprograms: String,
    @SerializedName("guarantee") var guarantee: String,
    @SerializedName("placesettings") var placesettings: String,
    @SerializedName("rinseaidindicator") var rinseaidindicator: String,
    @SerializedName("slimdepth") var slimdepth: String,
    @SerializedName("weightedwaterconsumptionfortheecocycle") var weightedwaterconsumptionfortheecocycle: String
)