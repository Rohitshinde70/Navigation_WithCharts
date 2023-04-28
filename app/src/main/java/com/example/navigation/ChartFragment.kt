package com.example.navigation

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ChartFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chartView()
    }

    private fun chartView() {
        val pieChart: PieChart = requireView().findViewById(R.id.pieChart_view)

        val dataEntries: ArrayList<PieEntry> = ArrayList()
        dataEntries.add(PieEntry(200f, "January"))
        dataEntries.add(PieEntry(300f, "February"))
        dataEntries.add(PieEntry(400f, "March"))
        dataEntries.add(PieEntry(500f, "April"))

        val pieDataSet = PieDataSet(dataEntries, "Salaries Overview")
        pieDataSet.colors = ColorTemplate.COLORFUL_COLORS.toList()
        pieDataSet.valueTextColor = Color.WHITE
        pieDataSet.valueTextSize = 12f

        val pieData = PieData(pieDataSet)
        pieChart.data = pieData

        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = false
        pieChart.setDrawHoleEnabled(true)
        pieChart.setTransparentCircleAlpha(0)
        pieChart.holeRadius = 0f
        pieChart.transparentCircleRadius = 61f
       // pieChart.setDrawCenterText(true)
        // pieChart.setCenterTextSize(16f)
        // pieChart.setCenterText("Salaries Overview")
        pieChart.legend.isEnabled = true
        pieDataSet.sliceSpace = 0f


        pieChart.invalidate()
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChartFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
