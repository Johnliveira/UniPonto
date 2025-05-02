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
            HistoryItem("27/12/2024", "08:20", "11:07 - 12:31", "17:20"),
            HistoryItem("28/12/2024", "08:00", "11:22 - 12:30", "17:00"),
            HistoryItem("29/12/2024", "08:15", "11:30 - 12:40", "17:15"),
            HistoryItem("30/12/2024", "08:20", "11:46 - 12:21", "17:20"),
            HistoryItem("31/12/2024", "08:20", "11:31 - 12:12", "17:20"),
            HistoryItem("03/01/2025", "12:20", "13:58 - 14:50", "18:20"),
            HistoryItem("07/01/2025", "09:20", "10:02 - 14:42", "17:20"),
            HistoryItem("08/01/2025", "08:37", "13:31 - 14:22", "18:20"),
            HistoryItem("09/01/2025", "07:58", "12:03 - 13:40", "18:20"),
            HistoryItem("10/01/2025", "08:20", "11:31 - 12:27", "17:20")
        )

        adapter = HistoryAdapter(mockData)
        recyclerView.adapter = adapter
    }
}
