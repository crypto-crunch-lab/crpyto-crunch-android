package com.crypto.cryptocrunch.domain.model

import com.crypto.cryptocrunch.data.model.DefiRepoDataRes

data class DefiRepo (

    var message: String,
    var data: DefiRepoDataRes
)

interface DefiRepoData {
    val id: String
    val name: String
    val platform: DefiPlatform
    val network: DefiNetwork
    val base: Double
    val reward: Double
    val apy: Double
    val tvl: Int
    val defiIconUrl: String
    val detailUrl: String
    val coinTypes: ArrayList<String>
    val apySeries: DefiSeries
    val tvlSeries: DefiSeries
    val syncYmdt: String
    val updateYmdt: String
    val historyUpdateYmdt: String
    val isService: Boolean
    val isRecommend: Boolean
}

interface DefiPlatform {
    val id: String
    val name: String
    val platformIconUrl: String
}

interface DefiNetwork {
    val name: String
    val networkIconUrl: String
}

interface DefiSeries {
    val histories: ArrayList<History>
    val maxValue: Double
    val minValue: Double
    val startYmd: String
    val endYmd: String
    val count: Int
}

interface History {
    val historyType: String
    val value: Double
    val syncYmd: String
}