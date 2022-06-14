package com.crypto.cryptocrunch.domain.usecase.defi

import android.util.Log
import com.crypto.cryptocrunch.data.model.DefiRepoRes
import com.crypto.cryptocrunch.domain.model.DefiRepo
import com.crypto.cryptocrunch.domain.repository.DefiRepository
import com.crypto.cryptocrunch.domain.usecase.base.BaseRequest
import com.crypto.cryptocrunch.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetDefiDetailUseCase @Inject constructor(private val repository: DefiRepository) : SingleUseCase<DefiRepo>()  {
    override fun buildUseCase(request: BaseRequest): Single<DefiRepo>? {
        val req = request as Request

        return repository.sendDefiId(req.id)
            .map {
                Log.d("nulkong", "getDefiDetail, message = " + it.message)
                DefiRepo(it.message, it.data)
            }
    }

    data class Request(
        val id: String
    ) : BaseRequest()

    override fun buildUseCase(): Single<DefiRepo>? {
        return null
    }

}
