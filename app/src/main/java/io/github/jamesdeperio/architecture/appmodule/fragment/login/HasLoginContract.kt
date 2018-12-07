/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.fragment.login

import io.github.jamesdeperio.architecture.global.model.temp.login.LoginRequest
import io.reactivex.disposables.Disposable
import kotlinx.coroutines.Job

/*
*  Contract class is responsible for methods and callback that are use for communication between the Controller, Implementation, ViewImplementation.
* */
interface HasLoginContract {
    /*
       Events are listener for user action.
    */
    interface Event {
        fun onLoginClick(username: String, password: String, shouldMockErrorResponse: Boolean)
    }

    /*
           ViewMethods are responsible for view manipulation.
     */
    interface ViewMethod {
        fun showErrorDialog(error: String):Job
        fun updateResponse(response: LoginRequest):Job
    }

    /*
      Presenter is in charge in processing data logic.
   */
    interface Presenter {
        fun login(username: String, password: String, shouldMockErrorResponse: Boolean): Disposable
    }

    /*
           State is condition of interpreter to identify which action to be done
     */
    interface State {
        fun isCredentialEmpty(username: String, password: String): Boolean
         fun isLoginRequestHasError(response: LoginRequest):Boolean
    }
}