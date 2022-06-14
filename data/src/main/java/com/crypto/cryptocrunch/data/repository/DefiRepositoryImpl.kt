package com.crypto.cryptocrunch.data.repository

import android.util.Log
import com.crypto.cryptocrunch.data.di.api.ApiClient
import com.crypto.cryptocrunch.data.model.DefiRepoRes
import com.crypto.cryptocrunch.domain.repository.DefiRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DefiRepositoryImpl(private val defiRepoRes: DefiRepoRes) : DefiRepository {
    val TAG = this.javaClass.simpleName

    override fun sendDefiId(id: String) : Single<DefiRepoRes> {
        return ApiClient.provideCryptoService()
            .getDefiDetail(id)
            .map {
                if (it.status.div(100) == 2) {
                    it
                }
                else {
                    Log.e(TAG, "error) $it")
                    throw Exception(it.toString())
                }
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .singleOrError()
    }
}