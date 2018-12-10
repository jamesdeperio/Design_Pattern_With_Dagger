/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.fragment.login

import io.github.jamesdeperio.architecture.global.util.subscribeCatchNetworkError
import io.github.jamesdeperio.architecture.integration.network.RestRepository
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class LoginImpl(
        private val viewMethod: HasLoginContract.ViewMethod,
        private val restRepository: RestRepository,
        private val state: HasLoginContract.State) : HasLoginContract.Presenter {
    override fun login(username: String, password: String, shouldMockErrorResponse: Boolean): Disposable
            = (if (shouldMockErrorResponse) restRepository.loginRequestError(username=username,password = password)
                else restRepository.loginRequest(username=username,password = password))
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .doOnNext { loginRequest ->
                viewMethod.updateResponse(response=loginRequest)
                if (state.isLoginRequestError(response= loginRequest))
                    viewMethod.showErrorDialog(error = "Invalid Credentials.")
            }
            .subscribeCatchNetworkError { viewMethod.showErrorDialog(error = "Something went wrong to web service.") }
            // doOnError does not catch all network error
            // ReactiveExtensions.subscribeCatchNetworkError is an extension method from Observable

}

