package com.example.shopkart.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shopkart.databinding.FragmentViewMessageBinding
import com.example.trainingproject.viewmodels.SharedViewModel

class ViewMessageFragment : Fragment() {

    private lateinit var binding: FragmentViewMessageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View{
        binding = FragmentViewMessageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)
        model.messageMutableLiveData.observe(viewLifecycleOwner, Observer {
            binding.viewMessage.text = it
        })
    }
}