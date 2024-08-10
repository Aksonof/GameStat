package com.example.everdalestat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.everdaleStat.databinding.GamePatternBinding
import com.example.everdaleStat.databinding.GameResultPatternBinding
import com.example.everdalestat.model.Game

class GameAdapter(private val actionListener: GameActionListener) :
    ListAdapter<Game, GameAdapter.GameViewHolder>(MyItemCallback()) {


    inner class GameViewHolder(
        private val binding: GamePatternBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: Game) {
            binding.gameName.text = item.name
            binding.removeGame.setOnClickListener {
                actionListener.onDeleteGame(item)
            }
            binding.root.setOnClickListener {
                actionListener.onShowGameStat(item)
            }

        }
    }

    class MyItemCallback : DiffUtil.ItemCallback<Game>() {
        override fun areItemsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Game, newItem: Game): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GamePatternBinding.inflate(inflater, parent, false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val item = getItem(position)
        holder.onBind(item)
    }
}