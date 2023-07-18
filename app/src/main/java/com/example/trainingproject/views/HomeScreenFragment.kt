package com.example.trainingproject.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.ViewModelProvider
import com.example.shopkart.R
import com.example.shopkart.databinding.FragmentHomeScreenBinding
import com.example.trainingproject.adapters.CustomShopItemAdapter
import com.example.trainingproject.baseresponsemodel.BaseResponse
import com.example.trainingproject.constants.Constants
import com.example.trainingproject.decorators.CustomItemDecorator
import com.example.trainingproject.helpers.GridAutofitLayoutManager
import com.example.trainingproject.models.ShoppingListResponse
import com.example.trainingproject.repository.ShoppingListRepository
import com.example.trainingproject.retrofitinstance.RetrofitInstance
import com.example.trainingproject.viewmodels.ShoppingListViewModel
import com.example.trainingproject.viewmodels.ShoppingListViewModelFactory

class HomeScreenFragment : Fragment() {

    private lateinit var binding: FragmentHomeScreenBinding
    private lateinit var viewModel: ShoppingListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val onCallBack: (position: ShoppingListResponse.ShoppingListModelItem) -> Unit = {
            onClick(it)
        }
        viewModel.getShoppingList()
        val recyclerView = binding.shopItemRecyclerView
        recyclerView.layoutManager = context?.let { GridAutofitLayoutManager(it, 450) }
        val decoration = CustomItemDecorator(15)
        recyclerView.addItemDecoration(decoration)
        viewModel._shoppingListResult.observe(viewLifecycleOwner) {
            when (it) {
                is BaseResponse.Loading -> {
                    Toast.makeText(context, "Loading", Toast.LENGTH_LONG).show()
                }

                is BaseResponse.Success -> {
                    recyclerView.adapter =
                        it.data?.let { list -> CustomShopItemAdapter(list, onCallBack) }

                }

                is BaseResponse.Error -> {
                    Toast.makeText(context, "Error getting shoppinglist ", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private fun onClick(item: ShoppingListResponse.ShoppingListModelItem) {

        parentFragmentManager.commit {
            val bundle = Bundle()
            bundle.putSerializable(Constants.SHOPPING_LIST_INSTANCE, item)
            setFragmentResult("request_key", bundle)
            replace<ProductDetailFragment>(R.id.navHostFragment)
            addToBackStack("product_details")

        }
        val activity = activity as HomeScreenActivity
        activity.binding.bottomNavigationHomeScreen.visibility = View.GONE
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentHomeScreenBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(
            this,
            ShoppingListViewModelFactory(ShoppingListRepository(RetrofitInstance(binding.root.context).getShoppingList))
        )[ShoppingListViewModel::class.java]
        return binding.root
    }

}