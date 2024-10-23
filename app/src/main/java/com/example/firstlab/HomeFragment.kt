package com.example.firstlab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.firstlab.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val user = arguments?.let { HomeFragmentArgs.fromBundle(it).user }

        binding.emailTextView.text = user?.email

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val chatList = listOf("Чат 1", "Чат 2", "Чат 3", "Чат 4")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, chatList)
        binding.chatListView.adapter = adapter
    }
}
