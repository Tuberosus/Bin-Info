package ru.me.bin_info.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.me.bin_info.databinding.HistoryItemBinding
import ru.me.bin_info.domain.models.HistoryItem

class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    inner class HistoryViewHolder(
        private val binding: HistoryItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(historyItem: HistoryItem) {
            binding.bin.text = historyItem.bin
            binding.bankName.text = historyItem.bankName
            binding.country.text = historyItem.country
        }
    }

    var historyItemList = emptyList<HistoryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            HistoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return historyItemList.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = historyItemList[position]
        holder.bind(item)
    }
}