/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.activity.main

import android.Manifest
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import io.github.jamesdeperio.architecture.appmodule.fragment.login.LoginController
import io.github.jamesdeperio.architecture.global.app.MainExceptionHandler
import io.github.jamesdeperio.architecture.global.base.DIBaseActivity
import io.github.jamesdeperio.architecture.global.util.Constant
import io.reactivex.disposables.CompositeDisposable
import jdp.pocketlib.util.EventBusManager
import javax.inject.Inject

/*
*  Controller is the Activity/Fragment that handles all event correspond to user action.
* */
class MainController : DIBaseActivity(), HasMainContract.Event {
    /*Inject the provided class in the Main Module/Global Module*/
    @field:[Inject] internal lateinit var presenter: HasMainContract.Presenter
    @field:[Inject] internal lateinit var viewMethod: HasMainContract.ViewMethod
    @field:[Inject] internal lateinit var state:HasMainContract.State
    @field:[Inject] internal lateinit var subscription: CompositeDisposable
    @field:[Inject] internal lateinit var eventBusManager: EventBusManager //this class is from global module

    /*
    * First method to be called.
    * Reset/Add default variables.
    * Adding of Permission
    * Subscribe the channels using event manager (Event Publisher)
    */
    override fun initialization(savedInstanceState: Bundle?) {
        Thread.setDefaultUncaughtExceptionHandler(MainExceptionHandler()) // add custom ANR catcher
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.INTERNET),Constant.INTERNET_REQUEST_CODE)
    }


    /*
     * Called after initialization.
     * Create an action on first load of the view.
     * Normally, loading of items in listview/recycleview should set here and configuring of start up view based on state
     */
    override fun onLoadEvent(savedInstanceState: Bundle?) {
        viewMethod.loadFragment(controller=LoginController())
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (state.isInternetPermitted(requestCode)) {
            // Do something
            // send action to fragment using event manager
        }
    }

    /* onResume is also being called after onLoadEvent*/
    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.dispose() // dispose your dispatcher bag
    }
}