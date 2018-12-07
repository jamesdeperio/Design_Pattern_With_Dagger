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
    fun provideComponent(controller: LoginController): LoginView {
        controller.rootView = controller.layoutInflater.inflate(R.layout.fragment_login, controller.container, false)
        return LoginView(
                view = controller.rootView!!,
                event = controller as HasLoginContract.Event,
                context = controller.context!!
        )
    }

    /*
  *  provide a viewMethod for LoginController to access the view.
  *  Since MainController is bind and LoginView is provided to this module, we can now use it as parameter.
  */
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: LoginController, view: LoginView): HasLoginContract.ViewMethod = LoginViewImpl(
            fragment = controller as Fragment,
            view = view
    )

    /*
   *  provide a presenter for LoginController to do the action and process.
   *  Since HasLoginContract.ViewMethod  is provided to this module, we can now use it as parameter.
   */
    @FragmentScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasLoginContract.ViewMethod, networkManager: NetworkManager, state:HasLoginContract.State): HasLoginContract.Presenter = LoginImpl(
            viewMethod = viewMethod,
            state= state,
            restRepository = networkManager.restRepository
    )


}