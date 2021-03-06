/**
 * @author github.com/jamesdeperio
 * @version codepocket template builder v1.0
 */
package io.github.jamesdeperio.architecture.global.base

import android.os.Bundle
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import jdp.pocketlib.base.BaseActivity
import javax.inject.Inject
import android.support.v4.app.Fragment as SupportFragment
/*
 Base class for Activity with DI integration
 */
abstract class DIBaseActivity : BaseActivity(), HasSupportFragmentInjector {
    @field:[Inject]
    internal lateinit var supportFragmentInjector: DispatchingAndroidInjector<SupportFragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun supportFragmentInjector(): AndroidInjector<SupportFragment> = supportFragmentInjector

    override fun initialization(savedInstanceState: Bundle?) {

    }

    override fun onLoadEvent(savedInstanceState: Bundle?) {

    }
}