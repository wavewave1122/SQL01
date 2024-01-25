package com.example.sql

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Toast
import com.example.sql.databinding.ActivityLoginBinding
import com.example.sql.databinding.ActivitySingupBinding
import javax.net.ssl.SSLSessionBindingEvent

class SingupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingupBinding
    private lateinit var databaseHlper: DatabaseHlper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHlper = DatabaseHlper(this)
    }

    private fun signupDatabase(username: String, password: String){
        val insertedRowId = databaseHlper.inserUser(username, password)
        if (insertedRowId != 1L){
            Toast.makeText(this,"Signup Successful", Toast.LENGTH_SHORT).show()
            val intent = (LoginActivity::class.java)
        }
    }
}