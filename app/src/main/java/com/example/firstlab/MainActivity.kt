package com.example.firstlab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.firstlab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), SignInFragment.OnSignInFragmentListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            navigateToOnboard()
        }
    }

    private fun navigateToOnboard() {
        replaceFragment(OnboardFragment())
    }

    override fun onSignInSuccess(email: String) {
        navigateToHome(email)
    }

    fun navigateToSignIn() {
        replaceFragment(SignInFragment())
    }

    fun navigateToRegistration() {
        replaceFragment(RegistrationFragment())
    }

    private fun navigateToHome(email: String) {
        val fragment = HomeFragment()
        val bundle = Bundle()
        bundle.putString("EMAIL", email)
        fragment.arguments = bundle
        replaceFragment(fragment)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
