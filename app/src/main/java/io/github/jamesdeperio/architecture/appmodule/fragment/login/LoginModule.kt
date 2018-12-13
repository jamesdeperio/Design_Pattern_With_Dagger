/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.fragment.login

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import io.github.jamesdeperio.architecture.R
import io.github.jamesdeperio.architecture.global.scope.FragmentScope
import io.github.jamesdeperio.architecture.integration.network.NetworkManager
import io.reactivex.disposables.CompositeDisposable
import jdp.pocketlib.util.UserPrefManager

@Module
object LoginModule {
    /*
    *  provide a rx java dispatcher bag for LoginController
    */
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()


    /*
   *  provide a evaluation class to identify the state
   */
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideState():HasLoginContract.State = LoginEval()

    /*
    * Setup the view and it's window properties needed for this screen.
     */
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: LoginController): LoginComponent {
        controller.rootView = controller.layoutInflater.inflate(R.layout.fragment_login, controller.container, false)
        return LoginComponent(
                view = controller.rootView!!,
                event = controller as HasLoginContract.Event,
                context = controller.context!!
        )
    }

    /*
  *  provide a viewMethod for LoginController to access the component.
  *  Since MainController is bind and LoginComponent is provided to this module, we can now use it as parameter.
  */
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: LoginController, component: LoginComponent): HasLoginContract.ViewMethod = LoginViewImpl(
            fragment = controller as Fragment,
            component = component
    )

    /*
   *  provide a presenter for LoginController to do the action and process.
   *  Since HasLoginContract.ViewMethod and HasLoginContract.State are  provided to this module, we can now use it as parameter.
   *  Since UserPrefManagerr and NetworkManager are  already provided in global module, we can now use it as parameter
   */
    @FragmentScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasLoginContract.ViewMethod, networkManager: NetworkManager, state:HasLoginContract.State, userPrefManager: UserPrefManager): HasLoginContract.Presenter = LoginImpl(
            viewMethod = viewMethod,
            state= state,
            restRepository = networkManager.restRepository,
            userPrefManager = userPrefManager
    )


}