package com.example.everdalestat.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.everdaleStat.databinding.FragmentStatBinding
import com.example.everdalestat.App
import com.example.everdalestat.GameResultActionListener
import com.example.everdalestat.GameResultAdapter
import com.example.everdalestat.model.GameResult
import com.example.everdalestat.viewModel.GameResultViewModel
import com.example.everdalestat.viewModel.GameResultViewModelFactory

class StatFragment : Fragment() {

    private lateinit var adapter: GameResultAdapter
    private val viewModel: GameResultViewModel by viewModels { GameResultViewModelFactory((requireActivity().application as App).gameResultRepository) }
    private var _binding: FragmentStatBinding? = null
    private val binding
        get() = _binding!!
    private val args: StatFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val game = args.Game

        binding.topic.text = "${game.name} game statistics"

        adapter = GameResultAdapter(object : GameResultActionListener {
            override fun onDeleteGameResult(gameResult: GameResult) {
                viewModel.delete(gameResult)
            }

            override fun onDetails(resultId: String) {

            }
        })


        val layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager

        viewModel.allGameResults(game.name).observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }


        binding.addGameResult.setOnClickListener {
            val action = StatFragmentDirections.actionStatFragmentToAddGameResultFragment(game)
            findNavController().navigate(action)
        }

        setFragmentResultListener("qwe") { _, bundle ->

            Log.d("StatFragment", "Attempting to set fragment result")

            val gameResult = bundle.getParcelable("gr", GameResult::class.java)

            if (gameResult != null) {
                viewModel.insert(gameResult)
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}