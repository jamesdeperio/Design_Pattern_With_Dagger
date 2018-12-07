/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package io.github.jamesdeperio.architecture.appmodule.activity.main

import io.github.jamesdeperio.architecture.global.util.Constant

/*
    interpreter's evaluation
 */
class MainEval : HasMainContract.State {
    override fun isInternetPermitted(requestCode: Int): Boolean
            = requestCode == Constant.INTERNET_REQUEST_CODE


}
