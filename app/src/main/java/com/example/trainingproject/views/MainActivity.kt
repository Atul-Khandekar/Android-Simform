package com.example.trainingproject.views

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.WindowManager.*
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.shopkart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("OnCreateActivity", "OnCreate Method called ")
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolBarMain.btnBack.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val inputMethodManager =
                this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(this.currentFocus?.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("onSaveInstanceStateActivity", "OnSaveInstanceState is called ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("onRestoreInstanceStateActivity", "OnRestoreState")
    }

    override fun onStart() {
        super.onStart()
        Log.d("OnStartActivity", "OnStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("OnResumeActivity", "OnResumeMethod called")

    }

    override fun onPause() {
        super.onPause()
        Log.d("OnPauseActivity", "OnPause method called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("OnStopActivity", "OnStop method called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("OnRestartActivity", "OnRestart method called ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroyActivity", "OnDestroy method called ")
    }

    override fun finish() {
        super.finish()
        Log.d("onFinish", "main Activity is finished")
    }
}