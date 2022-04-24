package com.crypto.cryptocrunch.domain.usecase.home


import com.crypto.cryptocrunch.domain.repository.HomeRepository
import javax.inject.Inject

class InsertInfoSkipUseCase @Inject constructor(private val repository: HomeRepository) {
    fun execute(skip: Boolean) {
        repository.infoSkip = skip
    }
}