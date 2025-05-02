package com.unitri.uniponto.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.unitri.uniponto.R
import com.unitri.uniponto.util.HistoryAdapter
import com.unitri.uniponto.util.HistoryItem

class HistoryFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HistoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.historyRecyclerView)

        val mockData = listOf(
            HistoryItem("27/12/2024", "8:20", "11:31 - 12:31", "17:20"),
            HistoryItem("28/12/2024", "8:00", "11:31 - 12:30", "17:00"),
            HistoryItem("29/12/2024", "8:15", "11:30 - 12:30", "17:15"),
            HistoryItem("30/12/2024", "8:20", "11:31 - 12:31", "17:20"),
            HistoryItem("30/12/2024", "8:20", "11:31 - 12:31", "17:20"),
            HistoryItem("30/12/2024", "8:20", "11:31 - 12:31", "17:20"),
            HistoryItem("30/12/2024", "8:20", "11:31 - 12:31", "17:20"),
            HistoryItem("30/12/2024", "8:20", "11:31 - 12:31", "17:20"),
            HistoryItem("30/12/2024", "8:20", "11:31 - 12:31", "17:20"),
            HistoryItem("02/01/2025", "8:20", "11:31 - 12:31", "17:20")
        )

        adapter = HistoryAdapter(mockData)
        recyclerView.adapter = adapter
    }
}
