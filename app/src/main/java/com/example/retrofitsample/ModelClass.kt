package com.example.retrofitsample

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ModelClass(
    @Expose
    @SerializedName("name")
    var name: String,
    @Expose
    @SerializedName("realname")
    var realname: String,
    @Expose
    @SerializedName("team")
    var team: String,
    @Expose
    @SerializedName("firstappearance")
    var firstappearance: String,
    @Expose
    @SerializedName("createdby")
    var createdby: String,
    @Expose
    @SerializedName("publisher")
    var publisher: String,
    @Expose
    @SerializedName("imageurl")
    var imageurl: String,
    @Expose
    @SerializedName("bio")
    var bio: String
)
