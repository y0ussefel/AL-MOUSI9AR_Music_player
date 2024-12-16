package com.example.tmezek.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.tmezek.MainActivity
import com.example.tmezek.R


class SignUpFragment : Fragment() {
    lateinit var maleRadio: RadioButton
    lateinit var femaleRadio: RadioButton
    lateinit var name : EditText
    lateinit var password : EditText
    lateinit var email : EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(
            R.layout.singup_page, container, false
        )

        name = view.findViewById(R.id.etName) // Assuming these IDs are correct
        email = view.findViewById(R.id.etEmail)
        password = view.findViewById(R.id.etPassword)
        maleRadio=view.findViewById(R.id.maleR)
        femaleRadio=view.findViewById(R.id.femaleR)


        val btnCheck = view.findViewById<ImageView>(R.id.toMain2)
        btnCheck.setOnClickListener{
            if(check()){
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }else {
                Toast.makeText(activity,"Please fill in all fields",Toast.LENGTH_SHORT).show()
            }

        }
        return view
    }

    private fun check():Boolean{
        return  name.text.isNotEmpty() && email.text.isNotEmpty() && password.text.isNotEmpty()
                && (maleRadio.isChecked || femaleRadio.isChecked)



    }

}