package com.example.tmezek

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.tmezek.fragments.AboutFragment
import com.example.tmezek.fragments.Activities
import com.example.tmezek.fragments.Favorites
import com.example.tmezek.fragments.PlayListFragment
import com.example.tmezek.fragments.ShareFragment
import com.example.tmezek.fragments.Songs
import com.example.tmezek.fragments.profileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawerLauout: DrawerLayout
    lateinit var activite : Activities
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
        setCurrentFragment(activite)

        btnNav.setOnItemSelectedListener { index ->
            when (index.itemId) {
                R.id.homeMe -> setCurrentFragment(activite)
                R.id.listSongsMe -> setCurrentFragment(songs)
                R.id.myFavMe-> setCurrentFragment(favorites)
                R.id.playListMe -> setCurrentFragment(PlayListFragment())

            }
            true

        }

        val floatBtn = findViewById<FloatingActionButton>(R.id.floatingBtn)

        floatBtn.setOnClickListener{
            Toast.makeText(this,"search fragemnt",Toast.LENGTH_SHORT).show()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
                R.id.home -> setCurrentFragment(activite)
                R.id.profile ->setCurrentFragment(profileFragment())
                R.id.share ->setCurrentFragment(ShareFragment())
                R.id.about ->setCurrentFragment(AboutFragment())
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

}