package com.unitri.uniponto.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.unitri.uniponto.R

class HistoryAdapter(private val items: List<HistoryItem>) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    inner class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date = view.findViewById<TextView>(R.id.dateTextView)
        val entry = view.findViewById<TextView>(R.id.entryTextView)
        val lunch = view.findViewById<TextView>(R.id.lunchTextView)
        val exit = view.findViewById<TextView>(R.id.exitTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = items[position]
        holder.date.text = item.date
        holder.entry.text = "Entrada: ${item.entry}"
        holder.lunch.text = "Almoço: ${item.lunch}"
        holder.exit.text = "Saída: ${item.exit}"
    }

    override fun getItemCount(): Int = items.size
}
