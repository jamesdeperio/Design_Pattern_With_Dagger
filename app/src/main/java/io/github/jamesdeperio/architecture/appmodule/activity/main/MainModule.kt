/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.activity.main

import android.annotation.SuppressLint
import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.jamesdeperio.architecture.R
import io.github.jamesdeperio.architecture.global.scope.ActivityScope
import io.github.jamesdeperio.architecture.global.scope.FragmentScope
import io.reactivex.disposables.CompositeDisposable

@Module
object MainModule {

    /*
     *  provide a rx java dispatcher bag for MainController
     */
    @ActivityScope
    @Provides
    @JvmStatic
    fun provideSubscription() = CompositeDisposable()


    /*
     *  provide a evaluation class to identify the state
     */
    @FragmentScope
    @Provides
    @JvmStatic
    fun provideState(): HasMainContract.State = MainEval()


    /*
    * Setup the view and it's window properties needed for this screen.
     */
    @SuppressLint("InflateParams")
    @ActivityScope
    @Provides
    @JvmStatic
    fun provideComponent(controller: MainController): MainView {
        val view = controller.layoutInflater.inflate(R.layout.activity_main, null)
        controller.setContentView(view)
        return MainView(
                view = view,
                event = controller as HasMainContract.Event,
                context = controller as Context
        )
    }

    /*
     *  provide a viewMethod for MainController to access the view.
     *  Since MainController is bind and MainView is provided to this module, we can now use it as parameter.
     */
    @ActivityScope
    @Provides
    @JvmStatic
    fun provideViewMethod(controller: MainController, view: MainView): HasMainContract.ViewMethod = MainViewImpl(
            context = controller as Context,
            view = view,
            fragmentManager = controller.supportFragmentManager!!
    )

    /*
    *  provide a presenter for MainController to do the action and process.
    *  Since HasMainContract.ViewMethod  is provided to this module, we can now use it as parameter.
    */
    @ActivityScope
    @Provides
    @JvmStatic
    fun providePresenter(viewMethod: HasMainContract.ViewMethod): HasMainContract.Presenter = MainImpl(
            viewMethod = viewMethod
    )


}