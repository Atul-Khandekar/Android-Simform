package com.example.trainingproject.views

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.shopkart.R
import com.example.shopkart.databinding.FragmentLoginBinding
import com.example.trainingproject.baseresponsemodel.BaseResponse
import com.example.trainingproject.helpers.SessionManager
import com.example.trainingproject.repository.LoginRepository
import com.example.trainingproject.retrofitinstance.RetrofitInstance
import com.example.trainingproject.viewmodels.LoginViewModel
import com.example.trainingproject.viewmodels.LoginViewModelFactory

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    private lateinit var sessionManager: SessionManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkInternetConnection()
        setUpOnClickListeners()
        setUpObservers()
    }

    private fun checkInternetConnection() {
        viewModel.hasInternetConnection(binding.root.context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(
            this,
            LoginViewModelFactory(LoginRepository(RetrofitInstance(binding.root.context).getLoginApi))
        )[LoginViewModel::class.java]
        sessionManager = SessionManager(binding.root.context)
        return binding.root
    }

    private fun setUpObservers() {

        viewModel._hasInternetConnection.observe(viewLifecycleOwner) {
            if (!it) {
                showAlert("No Internet connection")
            }
        }

        viewModel.loginResult.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    showLoading()
                }

                is BaseResponse.Success -> {
                    stopLoading()
                    if (it.data?.code == 0) {
                        Toast.makeText(context, "Login Successful", Toast.LENGTH_LONG).show()
                        sessionManager.saveAuthToken(it.data.data?.token.toString())
                        sessionManager.saveId(it.data.data?.id.toString())
                        goToHomeScreen()
                    } else {
                        Toast.makeText(context, it.data?.message, Toast.LENGTH_LONG).show()
                    }
                }

                is BaseResponse.Error -> {
                    stopLoading()
                    Toast.makeText(context, it.msg, Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

    private fun showLoading() {
        binding.loginProgressBar.visibility = View.VISIBLE
        binding.btnLogin.visibility = View.GONE
    }

    private fun stopLoading() {
        binding.loginProgressBar.visibility = View.GONE
        binding.btnLogin.visibility = View.VISIBLE
    }

    private fun goToHomeScreen() {
        val i = Intent(context, HomeScreenActivity::class.java)
        startActivity(i)
    }

    private fun showAlert(message: String) {
        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle(message)
        alertDialog.setCancelable(false)
        alertDialog.setPositiveButton("Exit") { dialog: DialogInterface?, _: Int ->
            dialog?.cancel()
            activity?.onBackPressedDispatcher?.onBackPressed()
        }
        alertDialog.show()
    }

    private fun setUpOnClickListeners() {
        binding.forgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_login_fragment_to_forgot_password_fragment)
        }

        binding.btnToRegister.setOnClickListener {
            parentFragmentManager.commit {
                replace<RegisterFragment>(R.id.navHostFragment)
                setReorderingAllowed(true)
                addToBackStack("register")
            }
        }

        binding.btnLogin.setOnClickListener {
            binding.apply {
                if (binding.loginActivityEmailTextField.text.toString()
                        .isEmpty() || binding.loginActivityPasswordTextField.text.toString()
                        .isEmpty()
                ) {
                    Toast.makeText(context, "Email or password can't be empty", Toast.LENGTH_SHORT)
                        .show()
                } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.loginActivityEmailTextField.text.toString())
                        .matches()
                ) {
                    Toast.makeText(context, "Please Enter Valid Email Address", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    viewModel.callLoginApi(
                        binding.loginActivityEmailTextField.text.toString(),
                        binding.loginActivityPasswordTextField.text.toString().toInt()
                    )
                }
            }
        }
    }
}