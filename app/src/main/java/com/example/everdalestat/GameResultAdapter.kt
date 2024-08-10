package com.example.everdalestat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.everdaleStat.databinding.GameResultPatternBinding
import com.example.everdalestat.model.GameResult


class GameResultAdapter(private val actionListener: GameResultActionListener) :
    ListAdapter<GameResult, GameResultAdapter.GameResultViewHolder>(MyItemCallback()) {


    inner class GameResultViewHolder(
        private val binding: GameResultPatternBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: GameResult) {

            binding.sum.text = item.sum.toString()
            binding.nickName.text = item.winner
            binding.date.text = item.date.toString()

            binding.details.setOnClickListener {
                actionListener.onDetails(item.playerResultId)
            }
            binding.remove.setOnClickListener {
                actionListener.onDeleteGameResult(item)
            }
        }
    }

    class MyItemCallback : DiffUtil.ItemCallback<GameResult>() {
        override fun areItemsTheSame(oldItem: GameResult, newItem: GameResult): Boolean {
            return oldItem.playerResultId == newItem.playerResultId
        }

        override fun areContentsTheSame(oldItem: GameResult, newItem: GameResult): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GameResultPatternBinding.inflate(inflater, parent, false)
        return GameResultViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameResultViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }
}
