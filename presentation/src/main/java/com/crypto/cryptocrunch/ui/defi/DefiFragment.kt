package com.crypto.cryptocrunch.ui.defi

import android.annotation.SuppressLint
import android.graphics.Color
import android.icu.util.LocaleData
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.crypto.cryptocrunch.R
import com.crypto.cryptocrunch.base.BaseFragment
import com.crypto.cryptocrunch.databinding.FragmentDefiBinding
import com.crypto.cryptocrunch.ui.home.DefiViewModel
import com.github.mikephil.charting.charts.CombinedChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import java.text.SimpleDateFormat
import java.time.LocalDate

const val MAXIMUM_DATE_DIFF = 185

class DefiFragment : BaseFragment<FragmentDefiBinding>() {
    override val layoutResId: Int
        get() = R.layout.fragment_defi

    private val viewModel = DefiViewModel()
    private lateinit var chart: CombinedChart

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            vm = viewModel
        }

        // Line Chart와 Bar Chart 생성
        chart = binding.combinedChart
        setData("2022-01-13", "2022-06-05")
        makeChart(chart)
    }

    override fun initObserver() {}

    /**
     * @brief 차트 데이터 세팅
     * @param startYmd 트래킹 시작 년.월.일
     * @param endYmd 현재 년.월.일
     */
    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.O)
    fun setData(startYmd: String, endYmd: String)
    {
        val endLocalDate = LocalDate.parse(endYmd)
        val startLocalDate = LocalDate.parse(startYmd)
        val limitLocalDate = endLocalDate.minusMonths(6)

        // 현재 시점을 기준으로 트래킹한 기간 계산
        val dateFormat = SimpleDateFormat("yyyy-mm-dd")
        val startDate = dateFormat.parse(startYmd)?.time
        val endDate = if(startLocalDate.isBefore(limitLocalDate)) dateFormat.parse(limitLocalDate.toString())?.time
                      else dateFormat.parse(endYmd)?.time
        val dateDiff = (endDate?.minus(startDate!!))?.div((24 * 60 * 60 * 1000))


        dateDiff?.let { generateTvlData(it) }
        dateDiff?.let { generateApyData(it) }
    }

    /**
     * @brief TVL 데이터 생성
     * @param
     */
    fun generateTvlData(count: Long)
    {

    }

    fun generateApyData(count: Long)
    {

    }


    fun makeChart(chart: CombinedChart)
    {
        // 차트 속성
        chart.description.isEnabled = false
        chart.setBackgroundColor(ColorTemplate.rgb("#18171E"))
        chart.setDrawGridBackground(false)
        chart.setDrawBarShadow(false)
        chart.isHighlightFullBarEnabled = false

        //Y축: Line
        val rightAxis: YAxis = chart.axisRight
        rightAxis.setDrawGridLines(false)
        //축 범위 설정
        rightAxis.axisMinimum = 1000f
        rightAxis.axisMaximum = 3000f

        //Y축: Bar
        val leftAxis: YAxis = chart.axisLeft
        leftAxis.setDrawGridLines(false)
        leftAxis.axisLineColor = ColorTemplate.rgb("#353A4E")
        leftAxis.axisMinimum = 0f //setStartAtZero(true)

        //x축 설정
        val xAxis = chart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.labelCount = 10
        xAxis.granularity = 1F
        xAxis.isGranularityEnabled = true
        //xAxis.valueFormatter = IndexAxisValueFormatter(testDataList)
        xAxis.axisMinimum = -0.5f

        //데이터 가져오기
        val data = CombinedData()
        data.setData(generateBarData())
        data.setData(generateLineData())
        //데이터 넣기
        chart.data = data
        //데이터 반영
        chart.invalidate()
    }

    private val chartLineColor:Int = Color.rgb(208, 214, 226)
    private val chartBarColor:Int = Color.argb(99,16, 69, 255)

    private fun generateLineData(): LineData? {

        // 임시 데이터
        val listData = ArrayList<Entry>()
        listData.add(Entry(0f, 2340f))
        listData.add(Entry(1f, 2310f))
        listData.add(Entry(2f, 2400f))
        listData.add(Entry(3f, 2280f))
        listData.add(Entry(4f, 2590f))
        listData.add(Entry(5f, 2000f))
        listData.add(Entry(6f, 2705f))

        val data = LineData()
        val set = LineDataSet(listData, "integrated")
        set.color = chartLineColor
        set.lineWidth = 6f
        set.fillColor = chartLineColor
        set.mode = LineDataSet.Mode.CUBIC_BEZIER
        set.setDrawValues(false)
        set.setDrawCircles(false)
        set.axisDependency = YAxis.AxisDependency.RIGHT
        data.addDataSet(set)
        return data
    }

    private fun generateBarData(): BarData? {

        // 임시 데이터
        val listData = ArrayList<BarEntry>()
        listData.add(BarEntry(0f, 40f))
        listData.add(BarEntry(1f, 30f))
        listData.add(BarEntry(2f, 30f))
        listData.add(BarEntry(3f, 40f))
        listData.add(BarEntry(4f, 20f))
        listData.add(BarEntry(5f, 20f))
        listData.add(BarEntry(6f, 25f))

        val data = BarData()
        val set = BarDataSet(listData, "today")
        set.color = chartBarColor
        set.axisDependency = YAxis.AxisDependency.LEFT
        data.addDataSet(set)
        data.barWidth = 0.5f
        return data
    }



    fun initialSetting() {
/*
         * BarChart : xml에서 추가한 BarChart의 객체를 선언하여, 최종적으로 만들어진 BarData를 건내줌
         * binding 객체를 통하여 BarChart에 접근
         */
        //val barChart: BarChart = binding.barChart // binding으로 접근하여 barData 전달
        val entryList = ArrayList<BarEntry>()
        val barDataSet = BarDataSet(entryList, "TestDataSet")
        val barData = BarData() // ',' 구분으로 여러 DataSet을 줄 수 있음

        //barChart.setTouchEnabled(true) // 터치 유무

        /*
         * BarEntry : BarChart에 표시될 데이터를 저장
         * 기본적으로 float 값이 들어가고, Int, String으로 바꾸고 싶은 경우 label을 다는 작업을 해야함
         */
        entryList.add(BarEntry(0f, 1f))
        entryList.add(BarEntry(1f, 5f))
        entryList.add(BarEntry(2f, 0f))

        /*
         * BarDataSet : BarEntry를 바탕으로 실제 Bar data set을 생성
         * 단순 데이터인 BarEnrty를 막대 모양으로 표시하기 위해 반드시 필요
         * 막대의 두께, 색, 테두리 등 다양한 설정이 가능
         */
        barDataSet.color = ColorTemplate.rgb("#ff7b22")
        barDataSet.valueTextColor = Color.BLACK
        barDataSet.valueTextSize = 16f

        /*
         * BarData : BarChart에 보여질 데이터를 구성
         * 하나의 BarData에는 여러개의 BarDataSet이 있을 수 있음 => 한 차트에서 여러 막대 그래프를 함께 보여주기 위한 목적
         * 여러개의 BarDataSet을 효율적으로 보여주기 위한 barWidth, groupBar와 같은 변수와 메소드를 제공함
         */
        barData.barWidth = 0.35f
        barData.addDataSet(barDataSet)

        //barChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        //barChart.data = barData
        //barChart.invalidate()
    }

}