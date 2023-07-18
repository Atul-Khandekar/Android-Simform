package com.example.trainingproject.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shopkart.R
import com.example.trainingproject.models.ShoppingListResponse
import com.squareup.picasso.Picasso

class CustomShopItemAdapter(private val itemList: ShoppingListResponse, val onCallBack: (ShoppingListResponse.ShoppingListModelItem) -> Unit) :
    RecyclerView.Adapter<CustomShopItemAdapter.ViewHolder>()  {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemImage: ImageView = itemView.findViewById(R.id.img_item)
        val itemName: TextView = itemView.findViewById(R.id.name_item)
        val itemPrice: TextView = itemView.findViewById(R.id.price_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        Log.d("onCreate","onCreate of ")
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("getitemcount","GetItem of  ${itemList.size}" )
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Picasso.with(holder.itemView.context).load(itemList[position].image).into(holder.itemImage)
        holder.itemName.text = itemList[position].title
        holder.itemPrice.text = itemList[position].price.toString()
        holder.itemView.setOnClickListener{
            onCallBack(itemList[position])
        }
    }
}
