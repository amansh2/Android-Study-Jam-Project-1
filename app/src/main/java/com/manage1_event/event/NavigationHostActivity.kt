package com.manage1_event.event

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView

import com.manage1_event.event.databinding.ActivityNavigationHostBinding
import java.lang.reflect.Array

//this activity acts just as a fragment holder

class NavigationHostActivity : AppCompatActivity()  {
    lateinit var navController: NavController
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView:NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityNavigationHostBinding = DataBindingUtil.setContentView(this,R.layout.activity_navigation_host)

       buildDrawerLayout(binding)
    }
    private fun buildDrawerLayout(binding: ActivityNavigationHostBinding){
        navController=this.findNavController(R.id.host_fragment)
        drawerLayout=binding.drawerLayout
        NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout)
        NavigationUI.setupWithNavController(binding.navigationView,navController)

    }



    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController,drawerLayout)
    }

    fun share(item:MenuItem){
        val intent= Intent(Intent.ACTION_SEND).apply {
            putExtra(
                Intent.EXTRA_TEXT,
                "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID
            )
            type = "text/plain"
        }
        startActivity(intent)
    }

    fun logout(item:MenuItem){
Toast.makeText(application.applicationContext,"Implement logout",Toast.LENGTH_SHORT).show()
    }
    fun contact(item: MenuItem){

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "*/*"
            putExtra(Intent.EXTRA_EMAIL, arrayOf("amanshdeep2@gmail.com",""))
            putExtra(Intent.EXTRA_SUBJECT, "hello")

        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }

        }
}







