package com.example.trainingproject.views

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.example.shopkart.databinding.FragmentProductDetailBinding
import com.example.trainingproject.constants.Constants
import com.example.trainingproject.models.ShoppingListResponse
import com.squareup.picasso.Picasso

class ProductDetailFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProductDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("request_key") { key, bundle ->
            val item = bundle.getSerializable(Constants.SHOPPING_LIST_INSTANCE) as ShoppingListResponse.ShoppingListModelItem
            binding.productDescriptionText.text = item.description
            binding.productTitle.text = item.title
            binding.productPrice.text = item.price.toString()
            Picasso.with(context).load(item.image).into(binding.imageProductBackground)
            binding.btnShare.setOnClickListener {
                val i = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(Constants.SHOPKART_BASE_URL)
                )
                startActivity(Intent.createChooser(i,"Open with"))
            }

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        val activity = activity as HomeScreenActivity
        activity.binding.bottomNavigationHomeScreen.visibility = View.VISIBLE
    }
}