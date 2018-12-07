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
 *   ViewImplementation (middleware/bridge for component) is the only class that can access and manipulate the assigned component.
 */
class LoginViewImpl(
        private val fragment: Fragment,
        private val component: LoginComponent
) : HasLoginContract.ViewMethod {
    /*
   * All method should run on UI Thread.
   */

    @SuppressLint("SetTextI18n")
    override fun updateResponse(response: LoginRequest): Job = GlobalScope.launch(Dispatchers.Main) {
        component.tvResponse.text ="Response:\n$response"
    }

    override fun showErrorDialog(error: String): Job = GlobalScope.launch(Dispatchers.Main) {
        component.errorDialog.description.text=error
        component.errorDialog.show()
    }
}