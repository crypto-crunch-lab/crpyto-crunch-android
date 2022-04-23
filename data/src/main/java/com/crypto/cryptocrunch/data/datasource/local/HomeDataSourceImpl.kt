package com.crypto.cryptocrunch.data.datasource.local

import com.crypto.cryptocrunch.data.utils.PreferenceManager


class HomeDataSourceImpl(private val preferenceManager: PreferenceManager) :
    HomeDataSource {
    override var infoSkip: Boolean
        get() = preferenceManager.infoSkip
        set(value) {
            preferenceManager.infoSkip = value
        }
}