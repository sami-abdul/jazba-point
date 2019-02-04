package com.expendive.jazbapoint.domain.api

import android.util.Log
import com.expendive.jazbapoint.OneLeggedApi10
import com.expendive.jazbapoint.models.Category
import com.expendive.jazbapoint.models.Product
import com.expendive.jazbapoint.util.AppConstants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.scribe.builder.ServiceBuilder
import org.scribe.model.OAuthRequest
import org.scribe.model.SignatureType
import org.scribe.model.Token
import org.scribe.model.Verb

/**
 * Created by Abdul Sami on 1/16/2018.
 */

class ProductFetcher(category: String) {

    companion object {
        const val COMPUTING_CATEGORY = "125"
        const val ACCESSORIES_CATEGORY = "45"
        const val PHONES_TABLETS_CATEGORY = "26"
        const val GROCERS_CATEGORY = "127"
        const val WOMEN_FASHION_CATEGORY = "0"
        const val MEN_FASHION_CATEGORY = "0"
    }

//    private val url = PRODUCTS_RETRIEVAL_URL + "/?category=" + category
    private val url = PRODUCTS_RETRIEVAL_URL + "/categories"

    private val service = ServiceBuilder().provider(OneLeggedApi10::class.java)
            .apiKey(CONSUMER_KEY)
            .apiSecret(CONSUMER_SECRET)
            .signatureType(SignatureType.QueryString)
            .debug()
            .build()
    private val request = OAuthRequest(Verb.GET, url)

    init {
        service.signRequest(Token("", ""), request)
    }

    fun getCategories(): List<Category> {
        val response = request.send()
        println(response.message)
        if (response.isSuccessful) {
            val gson = Gson()
            Log.v(AppConstants.APP_TAG, response.body)
            return gson.fromJson(response.body, object : TypeToken<List<Category>>() {}.type)
        }
        return ArrayList<Category>()
    }

    fun getProducts(): List<Product> {
        val response = request.send()
        if (response.isSuccessful) {
            val gson = Gson()
            Log.v(AppConstants.APP_TAG, response.body)
            return gson.fromJson(response.body, object : TypeToken<List<Product>>() {}.type)
        }
        return ArrayList<Product>()
    }

    fun getTopFeaturedProducts(): List<Product> {
        val response = request.send()
        if (response.isSuccessful) {
            val gson = Gson()
            Log.v(AppConstants.APP_TAG, response.body)
            val list: List<Product> = gson.fromJson(response.body, object : TypeToken<List<Product>>() {}.type)
            val products = ArrayList<Product>()
            for (item in list) {
//                if (item.featured &&
//                        item.catalogVisibility == "visible" &&
//                        item.inStock)
            }
        }
        return ArrayList<Product>()
    }
}