/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.activity.main

import io.github.jamesdeperio.architecture.appmodule.fragment.login.LoginController
import kotlinx.coroutines.Job

/*
*  Contract class is responsible for methods and callback that are use for communication between the Controller, Implementation, ViewImplementation.
* */
interface HasMainContract {
    /*
        Events are listener for user action.
     */
    interface Event

    /*
        ViewMethods are responsible for view manipulation.
     */
    interface ViewMethod {
        fun loadFragment(controller: LoginController):Job
    }

    /*
        Presenter is in charge in processing data logic.
     */
    interface Presenter

    /*
        State is condition of interpreter to identify which action to be done
     */
    interface State {
        fun isInternetPermitted(requestCode: Int): Boolean
    }
}