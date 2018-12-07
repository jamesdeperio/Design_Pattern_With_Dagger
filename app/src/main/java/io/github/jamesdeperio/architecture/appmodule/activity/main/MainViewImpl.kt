/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.activity.main

import android.content.Context
import android.support.v4.app.FragmentManager
import io.github.jamesdeperio.architecture.R
import io.github.jamesdeperio.architecture.appmodule.fragment.login.LoginController
import jdp.pocketlib.util.Navigate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/*
 *   ViewImplementation (middleware/bridge for view) is the only class that can access and manipulate the assigned view.
 */
class MainViewImpl(
        private val context: Context,
        private val view: MainView,
        private val fragmentManager: FragmentManager
) : HasMainContract.ViewMethod {
  /*
   * All method should run on UI Thread.
   */
  override fun loadFragment(controller: LoginController): Job = GlobalScope.launch(Dispatchers.Main) {
      Navigate.using(fragmentManager = fragmentManager)
              .change(layoutID = R.id.mainContainer)
              .to(fragmentToChange = controller)
              .withBackStack(isBackstackEnabled = false)
              .commit()
  }
}