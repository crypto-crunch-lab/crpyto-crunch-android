package com.crypto.cryptocrunch.domain.usecase.base

import io.reactivex.Single

abstract class SingleUseCase<P> : BaseUseCase() {

    internal abstract fun buildUseCase(request: BaseRequest): Single<P>?
    internal abstract fun buildUseCase(): Single<P>?

    fun execute(
        request: BaseRequest,
        onSuccess: ((t: P) -> Unit),
        onError: ((t: Throwable) -> Unit),
        onFinished: () -> Unit = {}
    ) {
        disposeLast()
        lastDisposable = buildUseCase(request)
            ?.doAfterTerminate(onFinished)
            ?.subscribe(onSuccess, onError)

        lastDisposable?.let {
            compositeDisposable.add(it)
        }
    }

    fun execute(
        onSuccess: ((t: P) -> Unit),
        onError: ((t: Throwable) -> Unit),
        onFinished: () -> Unit = {}
    ) {
        disposeLast()
        lastDisposable = buildUseCase()
            ?.doAfterTerminate(onFinished)
            ?.subscribe(onSuccess, onError)

        lastDisposable?.let {
            compositeDisposable.add(it)
        }
    }
}