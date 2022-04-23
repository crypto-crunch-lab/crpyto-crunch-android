package com.crypto.cryptocrunch.data.repository

import com.crypto.cryptocrunch.data.datasource.local.HomeDataSource
import com.crypto.cryptocrunch.domain.repository.HomeRepository


class HomeRepositoryImpl(private val homeDataSource: HomeDataSource) :
    HomeRepository {
    override var infoSkip: Boolean
        get() = homeDataSource.infoSkip
        set(value) {
            homeDataSource.infoSkip = value
        }
}