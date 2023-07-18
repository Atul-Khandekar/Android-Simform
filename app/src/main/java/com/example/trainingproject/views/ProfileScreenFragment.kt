package com.example.trainingproject.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shopkart.databinding.FragmentProfileScreenBinding
import com.example.trainingproject.baseresponsemodel.BaseResponse
import com.example.trainingproject.helpers.SessionManager
import com.example.trainingproject.repository.ProfileScreenRepository
import com.example.trainingproject.retrofitinstance.RetrofitInstance
import com.example.trainingproject.viewmodels.ProfileScreenViewModel
import com.example.trainingproject.viewmodels.ProfileScreenViewModelFactory
import com.squareup.picasso.Picasso

class ProfileScreenFragment : Fragment() {

    private lateinit var binding: FragmentProfileScreenBinding
    private lateinit var viewModel: ProfileScreenViewModel
    private lateinit var sessionManager: SessionManager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProfileScreen(sessionManager.fetchUserId().toString())
        viewModel.profileResult.observe(viewLifecycleOwner) {
            when(it) {
                is  BaseResponse.Success -> {
                    Picasso.with(context).load(it.data?.profilePicture).into(binding.imageProfile)
                    binding.profileName.text = it.data?.name
                    binding.profileEmail.text = it.data?.email
                    Toast.makeText(context,"Profile Loaded Successfully",Toast.LENGTH_LONG).show()
                }
                is BaseResponse.Loading -> {
                    Toast.makeText(context,"Loading",Toast.LENGTH_LONG).show()
                }
                is BaseResponse.Error -> {
                    Toast.makeText(context, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProfileScreenBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(
            this, ProfileScreenViewModelFactory(
                ProfileScreenRepository(RetrofitInstance(binding.root.context).getUserProfile)
            )
        )[ProfileScreenViewModel::class.java]
        sessionManager = SessionManager(binding.root.context)
        return binding.root
    }

}