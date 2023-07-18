package com.example.trainingproject.views

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shopkart.databinding.FragmentRegisterBinding
import com.example.trainingproject.baseresponsemodel.BaseResponse
import com.example.trainingproject.helpers.SessionManager
import com.example.trainingproject.repository.RegisterUserRepository
import com.example.trainingproject.retrofitinstance.RetrofitInstance
import com.example.trainingproject.viewmodels.RegisterViewModel
import com.example.trainingproject.viewmodels.RegisterViewModelFactory

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel
    private lateinit var sessionManager: SessionManager
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("onAttachFragment", "onAttach for fragment is called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("onCreateFragment", "OnCreate for the fragment is called ")
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sessionManager = SessionManager(binding.root.context)
        setUpObserver()
        setUpOnClickListeners()
    }

    private fun setUpObserver() {
        viewModel.registerResult.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    if (it.data?.code == 0) {
                        Toast.makeText(context, "Registration Successful", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(context, it.data?.message, Toast.LENGTH_LONG).show()
                    }
                }

                is BaseResponse.Error -> {
                    stopLoading()
                    Toast.makeText(context, "Registration Failed " + it.msg, Toast.LENGTH_LONG)
                        .show()
                }

            }
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.buttonRegister.visibility = View.GONE
    }

    private fun stopLoading() {
        binding.buttonRegister.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
    }

    private fun setUpOnClickListeners() {
        binding.buttonRegister.setOnClickListener {
            val email = binding.emailTextfield.text.toString()
            val name = binding.yourNameTextField.text.toString()
            val password = (binding.yourPasswordTextField.text).toString()
            if (email.isEmpty() || name.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    context, "Email , Password or Name cannot be Empty !!", Toast.LENGTH_SHORT
                ).show()
            } else {
                viewModel.registerUser(email, name, password.toInt())
            }

        }

        binding.btnToLogin.setOnClickListener {
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        Log.d("onCreateViewFragment", "onCreateView for fragment is called")
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(
            this,
            RegisterViewModelFactory(RegisterUserRepository(RetrofitInstance(binding.root.context).getRegisterApi))
        )[RegisterViewModel::class.java]
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.d("onStartFragment", "onStart method for fragment is called ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResumeFragment", "OnResume method for fragment is called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPauseFragment", "OnPause method for fragment is called ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStopFragment", "OnStop method for fragment is called ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("onDestroyViewFragment", "OnDestroyView for fragment is called ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroyFragment", "onDestroy for fragment is called ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("onDetachFragment", "OnDetach for fragment is called ")
    }
}