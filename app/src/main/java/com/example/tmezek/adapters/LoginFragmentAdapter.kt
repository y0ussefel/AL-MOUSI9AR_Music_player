package com.example.tmezek.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tmezek.fragments.LoginFragment
import com.example.tmezek.fragments.SignUpFragment

class LoginFragmentAdapter( manager: FragmentManager, lifeCycle : Lifecycle)
    :FragmentStateAdapter(manager,lifeCycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return if(position == 0){
            LoginFragment()
        }else{
            SignUpFragment()
        }
    }

}