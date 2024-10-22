package com.example.firstlab

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.firstlab.databinding.FragmentRegistrationBinding

class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val confirmPassword = binding.confirmPassword.text.toString()

            if (!isEmailValid(email)) {
                binding.email.error = "Неверный формат email"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.password.error = "Пароль не может быть пустым"
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                binding.confirmPassword.error = "Пароли не совпадают"
                return@setOnClickListener
            }

            Toast.makeText(context, "Регистрация успешна!", Toast.LENGTH_SHORT).show()
            (activity as MainActivity).navigateToSignIn()
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}

