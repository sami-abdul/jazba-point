package com.expendive.jazbapoint.ui.activities

import android.os.AsyncTask
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.expendive.jazbapoint.R

import com.expendive.jazbapoint.OneLeggedApi10
import com.expendive.jazbapoint.models.Category
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.scribe.builder.ServiceBuilder
import org.scribe.model.*

/**
 * Created by Abdul Sami on 12/14/2017.
 */

class MainActivity : AppCompatActivity(),
        NavigationView.OnNavigationItemSelectedListener {

    companion object {
        const val BASE_SITE = "jazbapoint.com"
        const val BASE_URL = "http://$BASE_SITE/wp-json/wc/v2/products/categories"

        const val CONSUMER_KEY = "ck_b02ab2bce51ebcdce45283610a62aa1017b6729e"
        const val CONSUMER_SECRET = "cs_df8e37f3c8acfac0ef34f32e38d13acf0cceea3d"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()

        val service = ServiceBuilder().provider(OneLeggedApi10::class.java)
                .apiKey(CONSUMER_KEY)
                .apiSecret(CONSUMER_SECRET)
                .signatureType(SignatureType.QueryString)
                .debug()
                .build()
        val request = OAuthRequest(Verb.GET, BASE_URL)
        service.signRequest(Token("", ""), request)

//        Thread {
//            val response = request.send()
//            if (response!!.isSuccessful) {
//                println("Res " + response.body)
//                val gson = Gson()
//                val obj = gson.fromJson(response.body, Product::class.java)
//            }
//        }.start()

        object : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg params: Void?): Void? {
                val response = request.send()
                if (response!!.isSuccessful) {
                    val gson = Gson()
                    val obj: List<Category> = gson.fromJson(response.body, object : TypeToken<List<Category>>() {}.type)
                    println(obj)
                }
                return null
            }
        }.execute()
    }

    fun initViews() {
        setContentView(R.layout.activity_main)
//        setSupportActionBar(mainToolbar)

//        mainCartFab.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }
//
//        val toggle = ActionBarDrawerToggle(
//                this, mainDrawerLayout, mainToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
//        mainDrawerLayout.setDrawerListener(toggle)
//        toggle.syncState()
//
//        mainNavView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        val drawer = findViewById(R.id.mainDrawerLayout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        val id = item.itemId
//
//        if (id == R.id.navComputing) {
//
//        } else if (id == R.id.navPhones) {
//
//        } else if (id == R.id.navGrocers) {
//
//        } else if (id == R.id.navFashion) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        val drawer = findViewById(R.id.mainDrawerLayout) as DrawerLayout
//        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
