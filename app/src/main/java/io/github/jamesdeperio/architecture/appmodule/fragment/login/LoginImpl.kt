/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.fragment.login

import io.github.jamesdeperio.architecture.global.model.temp.login.LoginRequest
import io.github.jamesdeperio.architecture.global.util.Constant
import io.github.jamesdeperio.architecture.global.util.subscribeCatchNetworkError
import io.github.jamesdeperio.architecture.integration.network.RestRepository
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import jdp.pocketlib.util.UserPrefManager

class LoginImpl(
        private val viewMethod: HasLoginContract.ViewMethod,
        private val restRepository: RestRepository,
        private val state: HasLoginContract.State,
        private val userPrefManager: UserPrefManager) : HasLoginContract.Presenter {
    override fun login(username: String, password: String, shouldMockErrorResponse: Boolean): Disposable
            = (if (shouldMockErrorResponse) restRepository.loginRequestError(username=username,password = password)  // subscribe on IO
                else restRepository.loginRequest(username=username,password = password))    // subscribe on IO
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .doOnNext { loginRequest ->          // observe on New Thread
                when {
                    state.isLoginRequestError(response= loginRequest) -> {
                        viewMethod.updateResponse(response=loginRequest)
                        viewMethod.showErrorDialog(error = "Custom error code from webservice.")
                    }
                    else -> {
                        userPrefManager.set<LoginRequest>(key = Constant.LOGIN_CREDENTIAL_KEY,value = loginRequest)            //save temp data
                        viewMethod.updateResponse(response = userPrefManager.get<LoginRequest>(Constant.LOGIN_CREDENTIAL_KEY))            //load temp data
                        viewMethod.showSuccessDialog(message="Login succeed.")
                    }
                }
            }
            .subscribeCatchNetworkError {
                it.printStackTrace()
                //if status code is not ok and accepted
                viewMethod.showErrorDialog(error = "Something went wrong to web service.") }
            // doOnError does not catch all network error
            // ReactiveExtensions.subscribeCatchNetworkError is an extension method from Observable

}

