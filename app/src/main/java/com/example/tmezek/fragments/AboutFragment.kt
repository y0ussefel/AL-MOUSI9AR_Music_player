package com.example.tmezek.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.tmezek.R

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set app name dynamically (optional)
        val appNameTextView = view.findViewById<TextView>(R.id.tv_app_name)
        appNameTextView.text = getString(R.string.app_name)

        // Set app version dynamically
        val appVersionTextView = view.findViewById<TextView>(R.id.tv_app_version)
        appVersionTextView.text = "Version: ${getAppVersion()}"

        // Handle Privacy Policy button
        val privacyPolicyButton = view.findViewById<Button>(R.id.btn_privacy_policy)
        privacyPolicyButton.setOnClickListener {
            openLink("https://your-privacy-policy-link.com")
        }

        // Handle Support button
        val supportButton = view.findViewById<Button>(R.id.btn_support)
        supportButton.setOnClickListener {
            openLink("mailto:support@example.com")
        }
    }

    private fun getAppVersion(): String? {
        return try {
            val packageInfo = requireContext().packageManager.getPackageInfo(requireContext().packageName, 0)
            packageInfo.versionName
        } catch (e: Exception) {
            "N/A"
        }
    }

    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
