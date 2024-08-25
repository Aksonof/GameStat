package com.example.everdalestat.fragments

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.everdaleStat.R
import com.example.everdaleStat.databinding.FragmentGamesBinding
import com.example.everdalestat.App
import com.example.everdalestat.GameActionListener
import com.example.everdalestat.GameAdapter
import com.example.everdalestat.model.Game
import com.example.everdalestat.viewModel.GameViewModel
import com.example.everdalestat.viewModel.GameViewModelFactory

class GamesFragment : Fragment() {

    private lateinit var adapter: GameAdapter
    private val viewModel: GameViewModel by viewModels { GameViewModelFactory((requireActivity().application as App).gameRepository) }
    private var _binding: FragmentGamesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = GameAdapter(object : GameActionListener {
            override fun onDeleteGame(game: Game) {
                viewModel.delete(game)
            }

            override fun onShowGameStat(game: Game) {
                val action = GamesFragmentDirections.actionGamesFragmentToStatFragment(game)
                findNavController().navigate(action)
            }
        })
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager

        viewModel.allGames.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.addGame.setOnClickListener {
            findNavController().navigate(R.id.action_gamesFragment_to_addGameFragment)
        }

        setFragmentResultListener("getGame") { _, bundle ->
            val game = bundle.getParcelable("game", Game::class.java)
            if (game != null) {
                viewModel.insert(game)
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}