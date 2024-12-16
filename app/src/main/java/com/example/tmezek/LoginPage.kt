package com.example.tmezek

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.tmezek.adapters.LoginFragmentAdapter
import com.google.android.material.tabs.TabLayout

class LoginPage : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tab : TabLayout
    private lateinit var fragmentAdapter : LoginFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_singup_tabs)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


         viewPager = findViewById(R.id.viewPager)
         tab = findViewById(R.id.tab)

        fragmentAdapter = LoginFragmentAdapter(supportFragmentManager,lifecycle)

        tab.addTab(tab.newTab().setText("Login"))
        tab.addTab(tab.newTab().setText("SignUp"))

        viewPager.adapter = fragmentAdapter


        tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if(tab != null){
                    viewPager.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tab.selectTab(tab.getTabAt(position))
            }
        })


    }


}