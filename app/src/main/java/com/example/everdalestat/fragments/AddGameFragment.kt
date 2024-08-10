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
            val gameName = binding.editTextGameName.text.toString()
            val field1 = binding.field1.text.toString()
            val field2 = binding.field2.text.toString()
            val field3 = binding.field3.text.toString()
            val field4 = binding.field4.text.toString()
            val field5 = binding.field5.text.toString()
            val field6 = binding.field6.text.toString()
            val field7 = binding.field7.text.toString()
            val field8 = binding.field8.text.toString()

            val bundle = bundleOf(
                "gameName" to gameName,
                "field1" to field1,
                "field2" to field2,
                "field3" to field3,
                "field4" to field4,
                "field5" to field5,
                "field6" to field6,
                "field7" to field7,
                "field8" to field8
            )
            setFragmentResult("requestKey", bundle)
            findNavController().popBackStack()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}