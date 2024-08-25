package com.example.everdalestat.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.everdaleStat.databinding.FragmentAddGameResultBinding
import com.example.everdalestat.App
import com.example.everdalestat.PlayerResultAdapter
import com.example.everdalestat.model.GameResult
import com.example.everdalestat.model.PlayerResult
import com.example.everdalestat.PlayerResultActionListener
import com.example.everdalestat.viewModel.PlayerResultViewModel
import com.example.everdalestat.viewModel.PlayerResultViewModelFactory
import java.time.LocalDate

class AddGameResultFragment : Fragment() {

    private lateinit var adapter: PlayerResultAdapter
    private val viewModel: PlayerResultViewModel by viewModels { PlayerResultViewModelFactory((requireActivity().application as App).playerResultRepository) }
    private var _binding: FragmentAddGameResultBinding? = null
    private val binding: FragmentAddGameResultBinding get() = _binding!!
    private val args: AddGameResultFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddGameResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PlayerResultAdapter(object : PlayerResultActionListener {

            override fun onDeletePlayerResult(playerResult: PlayerResult) {
                viewModel.delete(playerResult)
            }

            override fun onEditPlayerResult(playerResult: PlayerResult) {
                val action =
                    AddGameResultFragmentDirections.actionAddGameResultFragmentToEnterPointsFragment(
                        args.game,
                        null,
                        playerResult
                    )
                findNavController().navigate(action)
            }


        })
        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager


        viewModel.allPlayersResults(viewModel.getOrCreateGameId()).observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.addPlayerResult.setOnClickListener {
            val action =
                AddGameResultFragmentDirections.actionAddGameResultFragmentToEnterPointsFragment(
                    args.game, viewModel.getOrCreateGameId()
                )
            findNavController().navigate(action)
        }


        setFragmentResultListener("insertKey") { _, bundle ->
            val playerResult = bundle.getParcelable("playerResult", PlayerResult::class.java)
            if (playerResult != null) {
                viewModel.insert(playerResult)

                viewModel.playersResult[playerResult.name] =
                    playerResult.value1 + playerResult.value2 + playerResult.value3 +
                            playerResult.value4 + playerResult.value5 + playerResult.value6 +
                            playerResult.value7 + playerResult.value8
            }
        }

        setFragmentResultListener("editKey") { _, bundle ->
            val playerResult = bundle.getParcelable("playerResult", PlayerResult::class.java)
            if (playerResult != null) {
                viewModel.edit(playerResult)

                viewModel.playersResult[playerResult.name] =
                    playerResult.value1 + playerResult.value2 + playerResult.value3 +
                            playerResult.value4 + playerResult.value5 + playerResult.value6 +
                            playerResult.value7 + playerResult.value8
            }
        }

        binding.done.setOnClickListener {
            val currentDate: String = LocalDate.now().toString()
            val winner = viewModel.getWinner()?.first
            val sum = viewModel.getWinner()?.second

            val gameResult = GameResult(
                0, viewModel.getOrCreateGameId(), args.game.name,
                winner.toString(), sum!!, currentDate
            )
            Log.d(
                "mimi", "GameId: ${viewModel.getOrCreateGameId()}, sum: $sum, winner: $winner, " +
                        "date: $currentDate, game: ${args.game.name}"
            )
            val bundle = bundleOf("gr" to gameResult)
            setFragmentResult("qwe", bundle)
            findNavController().popBackStack()
        }
    }
}