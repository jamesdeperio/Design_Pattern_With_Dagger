/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.activity.main

/*
*  Implementation class is responsible to process the data and return it to the view using ViewMethod.
*  Also, to communicate with repositories/dao and other module attached to it.
* */
class MainImpl(
        private val viewMethod: HasMainContract.ViewMethod) : HasMainContract.Presenter
    /*
    * Methods are usually DISPOSABLE and running on Background Thread
    */
