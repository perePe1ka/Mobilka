package com.example.firstlab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.firstlab.databinding.ActivityMainBinding
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    lateinit var charactersRepository: CharactersRepository
    private lateinit var client: HttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        client = HttpClient(CIO)
        charactersRepository = CharactersRepository()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        if (savedInstanceState == null) {
            navController.navigate(R.id.onboardFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        client.close()
    }

}

