package com.example.everdalestat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.everdaleStat.databinding.FragmentGamesBinding
import com.example.everdalestat.GameActionListener
import com.example.everdalestat.GameAdapter
import com.example.everdalestat.model.Game
import com.example.everdalestat.viewModel.GameViewModel

class GamesFragment : Fragment() {

    private lateinit var adapter: GameAdapter
    private lateinit var viewModel: GameViewModel
    private var _binding: FragmentGamesBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = GameAdapter(object : GameActionListener {
            override fun onDeleteGame(game: Game) {

            }
        })
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}