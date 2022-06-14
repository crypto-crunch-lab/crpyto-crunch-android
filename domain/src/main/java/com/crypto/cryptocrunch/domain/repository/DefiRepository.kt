package com.crypto.cryptocrunch.domain.repository

import com.crypto.cryptocrunch.data.model.DefiRepoRes
import com.crypto.cryptocrunch.domain.model.DefiRepo
import io.reactivex.Single


interface DefiRepository {
    fun sendDefiId(id: String): Single<DefiRepo>
}