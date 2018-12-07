/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package io.github.jamesdeperio.architecture.global.module.appconfig

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.github.jamesdeperio.architecture.appmodule.fragment.login.LoginController
import io.github.jamesdeperio.architecture.appmodule.fragment.login.LoginModule
import io.github.jamesdeperio.architecture.global.scope.FragmentScope

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class FragmentBindingModule {
    /*
    DECLARATION OF SUB COMPONENT FOR FRAGMENTS
  */
    @FragmentScope
    @ContributesAndroidInjector(modules = [LoginModule::class]) //you can add more private module for LoginController
    internal abstract fun loginInjector(): LoginController

}