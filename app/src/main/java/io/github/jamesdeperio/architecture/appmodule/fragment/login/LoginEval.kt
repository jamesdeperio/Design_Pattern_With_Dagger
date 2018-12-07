/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.fragment.login

import io.github.jamesdeperio.architecture.global.model.temp.login.LoginRequest

/*
    interpreter evaluation
 */
class LoginEval : HasLoginContract.State {
    override fun isCredentialEmpty(username: String, password: String): Boolean
        = username.isEmpty() && password.isEmpty()

    override fun isLoginRequestHasError(response: LoginRequest): Boolean
        = response.errorMessage != null
}