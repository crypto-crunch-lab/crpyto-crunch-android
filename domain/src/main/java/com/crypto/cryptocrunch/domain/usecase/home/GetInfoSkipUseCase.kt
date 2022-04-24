package com.crypto.cryptocrunch.domain.usecase.home

import com.crypto.cryptocrunch.domain.repository.HomeRepository
import javax.inject.Inject

class GetInfoSkipUseCase @Inject constructor(private val repository: HomeRepository) {
    fun execute(): Boolean = repository.infoSkip
}