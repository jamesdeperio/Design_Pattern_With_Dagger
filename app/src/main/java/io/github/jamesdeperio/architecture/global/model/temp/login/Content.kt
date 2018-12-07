package io.github.jamesdeperio.architecture.global.model.temp.login

import com.google.gson.annotations.SerializedName

data class Content(
        @field:[SerializedName("address")]
        var address: String,
        @field:[SerializedName("age")]
        var age: Int,
        @field:[SerializedName("name")]
        var name: String
) {
    override fun toString(): String = "Content(address='$address', age=$age, name='$name')"
}