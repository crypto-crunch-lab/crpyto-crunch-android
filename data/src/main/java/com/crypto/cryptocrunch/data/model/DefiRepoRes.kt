package com.crypto.cryptocrunch.data.model

import com.crypto.cryptocrunch.domain.model.*
import com.google.gson.annotations.SerializedName

data class DefiRepoRes(
    var status: Int,
    var message: String,
    var data: DefiRepoDataRes
)

data class DefiRepoDataRes(
    @SerializedName("id")
    private val _id: String,
    @SerializedName("name")
    private val _name: String,
    @SerializedName("platform")
    private val _platform: DefiPlatformRes,
    @SerializedName("network")
    private val _network: DefiNetworkRes,
    @SerializedName("base")
    private val _base: Double,
    @SerializedName("reward")
    private val _reward: Double,
    @SerializedName("apy")
    private val _apy: Double,
    @SerializedName("tvl")
    private val _tvl: Int,
    @SerializedName("defiIconUrl")
    private val _defiIconUrl: String,
    @SerializedName("detailUrl")
    private val _detailUrl: String,
    @SerializedName("coinTypes")
    private val _coinTypes: ArrayList<String>,
    @SerializedName("apySeries")
    private val _apySeries: DefiSeriesRes,
    @SerializedName("tvlSeries")
    private val _tvlSeries: DefiSeries,
    @SerializedName("syncYmdt")
    private val _syncYmdt: String,
    @SerializedName("updateYmdt")
    private val _updateYmdt: String,
    @SerializedName("historyUpdateYmdt")
    private val _historyUpdateYmdt: String,
    @SerializedName("isService")
    private val _isService: Boolean,
    @SerializedName("isRecommend")
    private val _isRecommend: Boolean
) : DefiRepoData {
    override val id: String
        get() = _id
    override val name: String
        get() = _name
    override val platform: DefiPlatform
        get() = _platform
    override val network: DefiNetwork
        get() = _network
    override val base: Double
        get() = _base
    override val reward: Double
        get() = _reward
    override val apy: Double
        get() = _apy
    override val tvl: Int
        get() = _tvl
    override val defiIconUrl: String
        get() = _defiIconUrl
    override val detailUrl: String
        get() = _detailUrl
    override val coinTypes: ArrayList<String>
        get() = _coinTypes
    override val apySeries: DefiSeries
        get() = _apySeries
    override val tvlSeries: DefiSeries
        get() = _tvlSeries
    override val syncYmdt: String
        get() = _syncYmdt
    override val updateYmdt: String
        get() = _updateYmdt
    override val historyUpdateYmdt: String
        get() = _historyUpdateYmdt
    override val isService: Boolean
        get() = _isService
    override val isRecommend: Boolean
        get() = _isRecommend
}

data class DefiPlatformRes(
    @SerializedName("id")
    val _id: String,
    @SerializedName("name")
    val _name: String,
    @SerializedName("platformIconUrl")
    val _platformIconUrl: String
) : DefiPlatform {
    override val id: String
        get() = _id
    override val name: String
        get() = _name
    override val platformIconUrl: String
        get() = _platformIconUrl
}

data class DefiNetworkRes(
    @SerializedName("name")
    val _name: String,
    @SerializedName("networkIconUrl")
    val _networkIconUrl: String
) : DefiNetwork {
    override val name: String
        get() = _name
    override val networkIconUrl: String
        get() = _networkIconUrl
}

data class DefiSeriesRes(
    @SerializedName("histories")
    val _histories: ArrayList<History>,
    @SerializedName("maxValue")
    val _maxValue: Double,
    @SerializedName("minValue")
    val _minValue: Double,
    @SerializedName("startYmd")
    val _startYmd: String,
    @SerializedName("endYmd")
    val _endYmd: String,
    @SerializedName("count")
    val _count: Int
) : DefiSeries {
    override val histories: ArrayList<History>
        get() = _histories
    override val maxValue: Double
        get() = _maxValue
    override val minValue: Double
        get() = _minValue
    override val startYmd: String
        get() = _startYmd
    override val endYmd: String
        get() = _endYmd
    override val count: Int
        get() = _count
}

data class HistoryRes(
    @SerializedName("historyType")
    val _historyType: String,
    @SerializedName("value")
    val _value: Double,
    @SerializedName("syncYmd")
    val _syncYmdt: String
) : History {
    override val historyType: String
        get() = _historyType
    override val value: Double
        get() = _value
    override val syncYmd: String
        get() = _syncYmdt
}