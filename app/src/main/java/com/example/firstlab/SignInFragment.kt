package com.example.firstlab

import android.content.Context
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.firstlab.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding
    private lateinit var listener: OnSignInFragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSignInFragmentListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement OnSignInFragmentListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signInButton.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if (!isEmailValid(email)) {
                binding.email.error = "Invalid email format"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.password.error = "Password cannot be empty"
                return@setOnClickListener
            }

            if (email == "1@mail.ru" && password == "1") {
                listener.onSignInSuccess(email)
            } else {
                Toast.makeText(context, "Invalid credentials", Toast.LENGTH_SHORT).show()
            }
        }

        binding.signUpButton.setOnClickListener {
            (activity as MainActivity).navigateToRegistration()
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    interface OnSignInFragmentListener {
        fun onSignInSuccess(email: String)
    }
}

