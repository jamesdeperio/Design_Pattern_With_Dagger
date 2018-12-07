/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.fragment.login

import android.content.Context
import android.support.design.widget.TextInputEditText
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import io.github.jamesdeperio.architecture.R
import io.github.jamesdeperio.architecture.global.base.BaseView

/*
 * View is in charge in creating component and providing action to it.
 */
class LoginComponent(
        view: View,
        event: HasLoginContract.Event,
        context: Context):BaseView(context=context) {
    val tbUsername = view.findViewById<TextInputEditText>(R.id.tbUsername)!!
    val tbPassword = view.findViewById<TextInputEditText>(R.id.tbPassword)!!
    val cbResponse = view.findViewById<CheckBox>(R.id.cbResponse)!!
    val tvResponse = view.findViewById<TextView>(R.id.tvResponse)!!
    val btnLogin = view.findViewById<Button>(R.id.btnLogin)!!.apply {
        this.setOnClickListener {
            event.onLoginClick(
                    username=tbUsername.text.toString(),
                    password= tbPassword.text.toString(),
                    shouldMockErrorResponse=cbResponse.isChecked)
        }
    }
}