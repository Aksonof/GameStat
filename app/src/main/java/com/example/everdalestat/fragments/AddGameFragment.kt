package com.example.everdalestat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.everdaleStat.databinding.FragmentAddGameBinding
import com.example.everdalestat.model.Game

class AddGameFragment : Fragment() {

    private var _binding: FragmentAddGameBinding? = null
    private val binding: FragmentAddGameBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveButton.setOnClickListener {

            val game = Game(
                id,
                binding.field1.text.toString(),
                binding.field2.text.toString(),
                binding.field3.text.toString(),
                binding.field4.text.toString(),
                binding.field5.text.toString(),
                binding.field6.text.toString(),
                binding.field7.text.toString(),
                binding.field8.text.toString(),
                binding.editTextGameName.text.toString()
            )

            val bundle = bundleOf("game" to game)

            setFragmentResult("getGame", bundle)
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}