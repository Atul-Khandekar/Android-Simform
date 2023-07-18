package com.example.trainingproject.models

import android.net.Uri
import com.example.shopkart.R
import java.net.URL

data class ShopItemModel(val image: Int, val name: String, val price: String , val source: URL) {

    companion object {
        fun getShopItems(): List<ShopItemModel> {
            val data = listOf(
                ShopItemModel(R.drawable.ic_horlicks_image,"Horlicks", "$1.5",URL("https://www.amazon.in/Horlicks-Health-Nutrition-drink-Chocolate/dp/B00E3AP5KS/ref=sr_1_5?crid=1CV9KR5LA0Z93&keywords=horlicks&qid=1687862382&sprefix=horlicks%2Caps%2C298&sr=8-5")),
                ShopItemModel(R.drawable.ic_sprite_image,"sprite","$3",URL("https://www.amazon.in/Sprite-Can-300ml/dp/B07G15JDK1/ref=sr_1_4?crid=13K7YASNKIPEG&keywords=sprite+can&qid=1687863214&sprefix=sprite+can%2Caps%2C241&sr=8-4")),
                ShopItemModel(R.drawable.ic_edible_oil,"Emmamii Oil", "$10",URL("https://www.amazon.in/Emami-Healthy-Tasty-Kachi-Mustard/dp/B07H337ZGP/ref=sr_1_13_f3?crid=2GU5X05V1EO9T&keywords=emami+edible+oil&qid=1687863253&sprefix=emami+edible+oil%2Caps%2C182&sr=8-13")),
                ShopItemModel(R.drawable.ic_milk_packet,"Milk", "$1",URL("https://www.amazon.in/Cavins-Milkshake-Strawberry-200ml-Pack/dp/B00XBS5ASU/ref=sr_1_2_f3?crid=AT43TA9TJYRZ&keywords=milk+packet+cavins&qid=1687863324&sprefix=milk+packet+cavins%2Caps%2C175&sr=8-2")),
                ShopItemModel(R.drawable.ic_nescafe_image,"Nescafe Black Coffee", "$15",URL("https://www.amazon.in/Nescafe-Gold-Smooth-Coffee-Powder/dp/B07K6L3KC6/ref=sr_1_13?keywords=nescafe+black+coffee&qid=1687863391&sprefix=nescafe+black+cof%2Caps%2C189&sr=8-13")),
                ShopItemModel(R.drawable.ic_tea,"Tea", "$10",URL("https://www.amazon.in/Tata-Tea-Agni-Leaf-500g/dp/B00AP7YFFY/ref=sr_1_12?crid=1ERD4X90YI4BP&keywords=tea&qid=1687863437&sprefix=te%2Caps%2C203&sr=8-12")),
                ShopItemModel(R.drawable.ic_biscuit,"Parle Biscuit", "$5",URL("https://www.amazon.in/Parle-Black-Bourbon-Sandwich-Biscuit/dp/B082KYZMBD/ref=sr_1_33?crid=1EQUIISCERU07&keywords=parle+biscuit&qid=1687863595&sprefix=parle+biscui%2Caps%2C191&sr=8-33")),
                ShopItemModel(R.drawable.ic_facewash,"FaceWash", "$7" ,URL("https://www.amazon.in/Garnier-Fairness-Face-Wash-Complete/dp/B01MXS3ND8/ref=sr_1_27?crid=3A6XYRRI520XJ&keywords=garnier+face+wash&qid=1687863634&sprefix=garnier+face+wash%2Caps%2C192&sr=8-27")),
                ShopItemModel(R.drawable.ic_shoes_image,"Shoes", "$50" , URL("https://www.amazon.in/Campus-Harrow-PRO-Running-Shoes/dp/B09WJ7QW4X/ref=sr_1_13?crid=3W0YEDLMXABKH&keywords=shoes&qid=1687863676&sprefix=shoe%2Caps%2C189&sr=8-13")),
            )
            return data
        }
    }

}