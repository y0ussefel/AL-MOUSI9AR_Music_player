package com.example.tmezek

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.tmezek.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var activeFragment: Fragment
    private val fragments = mutableMapOf<String, Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Drawer setup
        drawerLayout = findViewById(R.id.darwerSlider)
        val toolbar = findViewById<Toolbar>(R.id.toolBar)
        setSupportActionBar(toolbar)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // Bottom Navigation setup
        val btnNav = findViewById<BottomNavigationView>(R.id.btnNav)
        fragments["ACTIVITIES"] = Activities()
        fragments["FAVORITES"] = Favorites()
        fragments["SONGS"] = Songs()
        fragments["SEARCH"] = SearchFragment()
        fragments["PLAYLIST"] = PlayListFragment()

        activeFragment = fragments["ACTIVITIES"]!!
        supportFragmentManager.beginTransaction().add(R.id.fl, activeFragment, "ACTIVITIES").commit()

        btnNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeMe -> switchFragment("ACTIVITIES")
                R.id.listSongsMe -> switchFragment("SONGS")
                R.id.myFavMe -> switchFragment("FAVORITES")
                R.id.searchMe -> switchFragment("SEARCH")
                R.id.playListMe -> switchFragment("PLAYLIST")
            }
            true
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> switchFragment("ACTIVITIES")
            R.id.profile -> switchFragment("PROFILE") { ProfileFragment() }
            R.id.share -> shareApp()
            R.id.about -> switchFragment("ABOUT") { AboutFragment() }
            R.id.logOut -> showLogoutConfirmation()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun switchFragment(tag: String, factory: (() -> Fragment)? = null) {
        val newFragment = fragments[tag] ?: factory?.invoke()?.also { fragments[tag] = it }
        if (newFragment != null && newFragment != activeFragment) {
            // Hide currently active fragment
            supportFragmentManager.beginTransaction().apply {
                hide(activeFragment)

                // Remove any modal fragments like SheetFragment
                val sheetFragment = supportFragmentManager.findFragmentByTag("SheetFragment")
                if (sheetFragment != null) {
                    remove(sheetFragment)
                }

                // Show or add the new fragment
                if (!newFragment.isAdded) {
                    add(R.id.fl, newFragment, tag)
                } else {
                    show(newFragment)
                }
            }.commit()
            activeFragment = newFragment
        }
    }


    private fun shareApp() {
        val appLink = "https://play.google.com/store/apps/details?id=com.example.tmezek"
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Check out this amazing app: $appLink")
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

    private fun showLogoutConfirmation() {
        AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes") { _, _ -> logout() }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun logout() {
        sharedPreferences.edit().clear().apply()
        val intent = Intent(this, LoginPage::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
