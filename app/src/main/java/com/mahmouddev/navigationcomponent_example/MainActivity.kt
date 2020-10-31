package com.mahmouddev.navigationcomponent_example

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initNavController()
        setUpBottomNavigationView()
        setupDrawerLayout()
        createBackArrowInsideToolbar()
    }

    private fun initNavController() {
        navController =
            (supportFragmentManager.findFragmentById(R.id.mainContainer) as NavHostFragment).findNavController()
    }

    private fun setUpBottomNavigationView() = bottomNav.setupWithNavController(navController)

    private fun createBackArrowInsideToolbar() {
        setSupportActionBar(toolbar)
        //appBarConfiguration use to handle DrawerLayout
        setupActionBarWithNavController(navController, appBarConfiguration)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController)
    }

    private fun setupDrawerLayout() {
        val fragmentSet = setOf(R.id.homeFragment, R.id.searchFragment, R.id.profileFragment)
        appBarConfiguration = AppBarConfiguration(fragmentSet, drawerLayout)


        navView.setupWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}