package com.example.everdalestat

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.everdaleStat.databinding.PlayerResultPatternBinding
import com.example.everdalestat.model.PlayerResult
import com.example.everdalestat.viewModel.PlayerResultActionListener

class PlayerResultAdapter(private val actionListener: PlayerResultActionListener) :
    ListAdapter<PlayerResult, PlayerResultAdapter.PlayerResultViewHolder>(MyItemCallback()) {

    inner class PlayerResultViewHolder(private val binding: PlayerResultPatternBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: PlayerResult) {
            binding.sum.text = sumAllPoints(item)
            binding.nickName.text = item.name

            binding.remove.setOnClickListener {
                actionListener.onDeletePlayerResult(item)
            }

        }

        private fun sumAllPoints(item: PlayerResult): CharSequence {
            val result: Int
            with(item) {
                result = value1 + value2 + value3 + value4 + value5 + value6 + value7 + value8
            }
            return result.toString()
        }
    }


    class MyItemCallback : DiffUtil.ItemCallback<PlayerResult>() {

        override fun areItemsTheSame(oldItem: PlayerResult, newItem: PlayerResult): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PlayerResult, newItem: PlayerResult): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PlayerResultPatternBinding.inflate(inflater, parent, false)
        return PlayerResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerResultViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }

}


