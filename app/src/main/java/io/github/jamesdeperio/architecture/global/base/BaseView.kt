package io.github.jamesdeperio.architecture.global.base

import android.content.Context
import jdp.pocketlib.widget.PocketDialog
/*
 * This is a base view for dialog
 */
open class BaseView (context:Context){
    open val errorDialog = PocketDialog(context=context,type = PocketDialog.Type.DIALOG_ERROR).apply {
        //set default attributes
    }

    open val successDialog = PocketDialog(context=context,type = PocketDialog.Type.DIALOG_SUCCESS).apply {
        //set default attributes
    }
}