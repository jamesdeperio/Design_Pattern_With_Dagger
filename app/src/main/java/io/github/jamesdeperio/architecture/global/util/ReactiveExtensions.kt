package io.github.jamesdeperio.architecture.global.util

import io.reactivex.Observable
import io.reactivex.annotations.SchedulerSupport
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.internal.functions.Functions


/*
 * doOnError does not catch all network error
 * ReactiveExtensions.subscribeCatchNetworkError is an extension method from Observable
 */
@SchedulerSupport(SchedulerSupport.NONE)
fun <T> Observable<T>.subscribeCatchNetworkError(error: ()->Unit = {}): Disposable {
    return subscribe(Functions.emptyConsumer<Any>(), Consumer {  error() }, Functions.EMPTY_ACTION, Functions.emptyConsumer<Any>())
}