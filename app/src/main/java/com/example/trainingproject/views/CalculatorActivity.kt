package com.example.trainingproject.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shopkart.R
import com.example.shopkart.databinding.ActivityCalculatorBinding
import com.example.trainingproject.adapters.CalculatorAdapter
import com.example.trainingproject.models.CalculatorDataModel
import com.example.trainingproject.models.ImageDataModel
import com.example.trainingproject.models.SpinnerRowItemModel

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("oncreate", "CalculatorActivity onCreate")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calculator)
        var k: Long = 2

        var data = CalculatorDataModel.getData()
        val recyclerView = binding.calculatorRecyclerView
        val calculatorAdapter = CalculatorAdapter(data)
        recyclerView.adapter = calculatorAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        binding.btnAddMore.setOnClickListener {
            data.add(
                CalculatorDataModel(
                    k,
                    MutableLiveData("0"),
                    MutableLiveData("0"),
                    arrayListOf(SpinnerRowItemModel(0)),
                    MutableLiveData("0"),
                    arrayListOf(
                        ImageDataModel(ImageDataModel.getImage())
                    )
                )
            )
            k += 1
            recyclerView.adapter?.notifyDataSetChanged()
        }
    }

    //methods to check lifecycle states
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("save state", " Calculator Activity OnSaveInstanceState is called ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("restore state", "Calculator Activity OnRestoreState")
    }

    override fun onStart() {
        super.onStart()
        Log.d("OnStart", "Calculator Activity OnStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d("OnResume", "Calculator Activity OnResumeMethod called")
    }

    override fun onPause() {
        super.onPause()
        Log.d("OnPause", "Calculator Activity OnPause method called")
    }

    override fun onStop() {
        super.onStop()
        Log.d("OnStop", "Calculator Activity OnStop method called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("OnRestart", "Calculator Activity OnRestart method called ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroy", "Calculator Activity OnDestroy method called ")
    }

    override fun finish() {
        super.finish()
        Log.d("onFinish", "Calculator Activity finish method called ")
    }

}