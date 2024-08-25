package com.example.everdalestat.fragments

import android.os.Bundle
import android.text.Editable
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

    private var onEditMode = false

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

        if (args.playerResult != null) {
            onEditMode = true
            binding.name.setText(args.playerResult!!.name)
        }

        setFieldVisibility(binding.field1, args.game.value1, args.playerResult?.value1.toString())
        setFieldVisibility(binding.field2, args.game.value2, args.playerResult?.value2.toString())
        setFieldVisibility(binding.field3, args.game.value3, args.playerResult?.value3.toString())
        setFieldVisibility(binding.field4, args.game.value4, args.playerResult?.value4.toString())
        setFieldVisibility(binding.field5, args.game.value5, args.playerResult?.value5.toString())
        setFieldVisibility(binding.field6, args.game.value6, args.playerResult?.value6.toString())
        setFieldVisibility(binding.field7, args.game.value7, args.playerResult?.value7.toString())
        setFieldVisibility(binding.field8, args.game.value8, args.playerResult?.value8.toString())


        binding.saveButton.setOnClickListener {

            val playerName = binding.name.text.toString()

            val fields = listOf(
                binding.field1, binding.field2, binding.field3, binding.field4,
                binding.field5, binding.field6, binding.field7, binding.field8
            )

            val fieldValues = fields.map { field ->
                field.text.toString().toIntOrNull() ?: 0
            }
            var id = 0
            if (onEditMode) {
                id = args.playerResult?.id ?: 0
            }
            val playerResult = PlayerResult(
                id,
                args.playerResultId.toString(),
                fieldValues[0], fieldValues[1], fieldValues[2], fieldValues[3],
                fieldValues[4], fieldValues[5], fieldValues[6], fieldValues[7],
                playerName
            )

            val bundle = bundleOf(
                "playerResult" to playerResult
            )

            setFragmentResult("editKey", bundle)
            setFragmentResult("insertKey", bundle)
            findNavController().popBackStack()
        }

    }


    private fun setFieldVisibility(field: TextView, hint: String, value: String) {
        if (value.isNotEmpty()) {
            field.hint = hint
            field.visibility = View.VISIBLE

            if (onEditMode) {
                field.text = value
            }

        } else {
            field.visibility = View.GONE
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}