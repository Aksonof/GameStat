package com.example.everdalestat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.everdaleStat.databinding.FragmentEnterPointsBinding
import com.example.everdalestat.model.PlayerResult

class EnterPointsFragment : Fragment() {


    private var _binding: FragmentEnterPointsBinding? = null
    private val binding: FragmentEnterPointsBinding get() = _binding!!
    private val args: EnterPointsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterPointsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFieldVisibility(binding.field1, args.game.value1)
        setFieldVisibility(binding.field2, args.game.value2)
        setFieldVisibility(binding.field3, args.game.value3)
        setFieldVisibility(binding.field4, args.game.value4)
        setFieldVisibility(binding.field5, args.game.value5)
        setFieldVisibility(binding.field6, args.game.value6)
        setFieldVisibility(binding.field7, args.game.value7)
        setFieldVisibility(binding.field8, args.game.value8)

        binding.saveButton.setOnClickListener {
            val playerName = binding.name.text.toString()

            val fields = listOf(
                binding.field1, binding.field2, binding.field3, binding.field4,
                binding.field5, binding.field6, binding.field7, binding.field8
            )

            val fieldValues = fields.map { field ->
                field.text.toString().toIntOrNull() ?: 0
            }

            val playerResult = PlayerResult(
                0,
                args.playerResultId,
                fieldValues[0], fieldValues[1], fieldValues[2], fieldValues[3],
                fieldValues[4], fieldValues[5], fieldValues[6], fieldValues[7],
                playerName
            )

            val bundle = bundleOf(
                "playerResult" to playerResult
            )

            setFragmentResult("requestKey", bundle)
            findNavController().popBackStack()
        }

    }


    private fun setFieldVisibility(field: TextView, value: String) {
        if (value.isNotEmpty()) {
            field.hint = value
            field.visibility = View.VISIBLE
        } else {
            field.visibility = View.GONE
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}