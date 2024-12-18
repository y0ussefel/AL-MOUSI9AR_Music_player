package com.example.tmezek

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.tmezek.fragments.AboutFragment
import com.example.tmezek.fragments.Activities
import com.example.tmezek.fragments.Favorites
import com.example.tmezek.fragments.PlayListFragment
import com.example.tmezek.fragments.SearchFragment
import com.example.tmezek.fragments.ShareFragment
import com.example.tmezek.fragments.Songs
import com.example.tmezek.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLauout: DrawerLayout
    lateinit var activite : Activities
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        drawerLauout = findViewById(R.id.darwerSlider)

        val toolBar = findViewById<Toolbar>(R.id.toolBar)
        setSupportActionBar(toolBar)

            val navView = findViewById<NavigationView>(R.id.nav_view)
            navView.setNavigationItemSelectedListener(this)

        val toggle =
            ActionBarDrawerToggle(this, drawerLauout, toolBar, R.string.open, R.string.close)
        drawerLauout.addDrawerListener(toggle)
        toggle.syncState()


        val btnNav = findViewById<BottomNavigationView>(R.id.btnNav)
        activite = Activities()
        val favorites = Favorites()
        val songs = Songs()
        val search = SearchFragment()
        val playList = PlayListFragment()

        setCurrentFragment(activite)

        btnNav.setOnItemSelectedListener { index ->
            when (index.itemId) {
                R.id.homeMe -> setCurrentFragment(activite)
                R.id.listSongsMe -> setCurrentFragment(songs)
                R.id.myFavMe-> setCurrentFragment(favorites)
                R.id.searchMe-> setCurrentFragment(search)
                R.id.playListMe -> setCurrentFragment(playList)

            }
            true

        }



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val profile = ProfileFragment()
        when(item.itemId){
                R.id.home -> setCurrentFragment(activite)
                R.id.profile ->setCurrentFragment(profile)
                R.id.share ->shareApp()
                R.id.about ->setCurrentFragment(AboutFragment())
                R.id.logOut ->showLogoutConfirmation()
        }
        drawerLauout.closeDrawer(GravityCompat.START)
        return true
    }

    @Deprecated("This method has been deprecated in favor of using the\n      {@link OnBackPressedDispatcher} via {@link #getOnBackPressedDispatcher()}.\n      The OnBackPressedDispatcher controls how back button events are dispatched\n      to one or more {@link OnBackPressedCallback} objects.")
    override fun onBackPressed() {

        if (drawerLauout.isDrawerOpen(GravityCompat.START)){
            drawerLauout.closeDrawer(GravityCompat.START)
        }else{
            super. onBackPressedDispatcher.onBackPressed()
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl, fragment)
            commit()
        }
    private fun shareApp() {
        val appLink = "https://play.google.com/store/apps/details?id=com.example.tmezek"

        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, "Check out this amazing app: $appLink")
        }
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

    private fun logout() {

        sharedPreferences.edit().clear().apply()

        val intent = Intent(this, LoginPage::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
    private fun showLogoutConfirmation() {
        AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes") { _, _ -> logout() }
            .setNegativeButton("Cancel", null)
            .show()
    }


}