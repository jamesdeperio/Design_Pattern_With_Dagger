package io.github.jamesdeperio.architecture.global.model.temp.login

import com.google.gson.annotations.SerializedName

data class LoginRequest(
        @field:[SerializedName("content")]
        var content: Content?   ,
        @field:[SerializedName("error_code")]
        var errorCode: Int = 0,
        @field:[SerializedName("error_message")]
        var errorMessage: String? = null
) {
    override fun toString(): String =
            "LoginRequest(content=$content, errorCode=$errorCode, errorMessage=$errorMessage)"
}