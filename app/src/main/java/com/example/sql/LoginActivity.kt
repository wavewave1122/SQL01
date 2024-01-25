package com.example.sql

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

import com.example.sql.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding
    private  lateinit var databaseHelper: DatabaseHlper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

       databaseHelper = DatabaseHlper(this)

        binding.loginButton.setOnClickListener {
            val  loginUsername = binding.loginUsername.text.toString()
            val  loginPassword = binding.loginPassword.text.toString()
            loginDatabase(loginUsername,loginPassword)
        }
        binding.loginRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun loginDatabase(username: String, password: String){
        val userExists = databaseHelper.readUser(username, password)
        if (userExists){
            Toast.makeText(this,"Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast.makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
        }
    }
}