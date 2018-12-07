/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.fragment.login

import android.os.Bundle
import io.github.jamesdeperio.architecture.global.base.DIBaseFragment
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject
/*
*  Controller is the Activity/Fragment that handles all event correspond to user action.
* */
class LoginController : DIBaseFragment(), HasLoginContract.Event {
    @field:[Inject] internal lateinit var presenter: HasLoginContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasLoginContract.ViewMethod
    @field:[Inject] internal lateinit var state: HasLoginContract.State
    @field:[Inject] internal lateinit var subscription: CompositeDisposable

    /*
  * First method to be called.
  * Reset/Add default variables.
  * Adding of Permission
  * Subscribe the channels using event manager (Event Publisher)
  */
    override fun initialization(savedInstanceState: Bundle?) {}


    /*
     * Called after initialization.
     * Create an action on first load of the view.
     * Normally, loading of items in listview/recycleview should set here and configuring of start up view based on state
     */
    override fun onLoadEvent(savedInstanceState: Bundle?) {}

    /* onResume is also being called after onLoadEvent*/
    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        subscription.dispose()
    }

    /*
      LOGIN BUTTON EVENT LISTENER
      write code like what should the user expected to happen
                if  the credential is empty(STATE) , show an error
                else, try to login (PROCESS)
     */
    override fun onLoginClick(username: String, password: String, shouldMockErrorResponse: Boolean) {
        when {
            state.isCredentialEmpty(username= username, password=password) ->
                viewMethod.showErrorDialog(error="Please enter your credentials.")
            else -> subscription.add(presenter.login(username=username, password=password, shouldMockErrorResponse=shouldMockErrorResponse))
        }
    }
}