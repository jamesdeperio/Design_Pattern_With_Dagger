/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.fragment.login

import android.annotation.SuppressLint
import android.support.v4.app.Fragment
import io.github.jamesdeperio.architecture.global.model.temp.login.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/*
 *   ViewImplementation (middleware/bridge for view) is the only class that can access and manipulate the assigned view.
 */
class LoginViewImpl(
        private val fragment: Fragment,
        private val view: LoginView
) : HasLoginContract.ViewMethod {
    /*
   * All method should run on UI Thread.
   */

    @SuppressLint("SetTextI18n")
    override fun updateResponse(response: LoginRequest): Job = GlobalScope.launch(Dispatchers.Main) {
        view.tvResponse.text ="Response:\n$response"
    }

    override fun showErrorDialog(error: String): Job = GlobalScope.launch(Dispatchers.Main) {
        view.errorDialog.description.text=error
        view.errorDialog.show()
    }
}