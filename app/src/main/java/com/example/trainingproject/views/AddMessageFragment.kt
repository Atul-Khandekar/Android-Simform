package com.example.shopkart.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.shopkart.databinding.FragmentAddMessageBinding
import com.example.trainingproject.viewmodels.SharedViewModel

class AddMessageFragment : Fragment() {

    private lateinit var binding: FragmentAddMessageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAddMessageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val model = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        model.messageMutableLiveData.observe(viewLifecycleOwner) {
            binding.messageToSave.setText(it)
        }
        binding.btnSaveMessage.setOnClickListener {
            model.sendMessage(binding.messageToSave.text.toString())
            Toast.makeText(context, "Messaged saved successfully", Toast.LENGTH_LONG).show()
        }
    }
}