/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package io.github.jamesdeperio.architecture.global.module.appconfig

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.github.jamesdeperio.architecture.appmodule.activity.main.MainController
import io.github.jamesdeperio.architecture.appmodule.activity.main.MainModule
import io.github.jamesdeperio.architecture.global.scope.ActivityScope

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class ActivityBindingModule {
/*
   DECLARATION OF SUB COMPONENT FOR ACTIVITIES
 */
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class]) //you can add more private module for MainController
    internal abstract fun mainInjector(): MainController

}