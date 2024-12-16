package com.example.tmezek.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.tmezek.MainActivity
import com.example.tmezek.R


class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(
            R.layout.login_page, container, false
        )

       val btnArrow = view.findViewById<ImageView>(R.id.toMain)
        btnArrow.setOnClickListener{
            val intent = Intent(activity,MainActivity::class.java)
            startActivity(intent)
        }
        return view
    }


}