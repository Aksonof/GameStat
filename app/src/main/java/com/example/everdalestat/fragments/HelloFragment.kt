package com.example.everdalestat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.everdaleStat.R
import com.example.everdaleStat.databinding.FragmentHelloBinding

class HelloFragment : Fragment() {

    private var _binding: FragmentHelloBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHelloBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.startButton.setOnClickListener {
            findNavController().navigate(R.id.action_helloFragment_to_gamesFragment)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}