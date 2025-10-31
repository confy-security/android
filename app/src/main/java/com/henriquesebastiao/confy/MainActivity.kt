package com.henriquesebastiao.confy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.henriquesebastiao.confy.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Actions performed when the connect button is clicked.
        binding.buttonConnect.setOnClickListener {
            // The method trim() removes any leading or trailing whitespace from the input.
            val usernameInput: String = binding.usernameInput.text.toString().trim()
            val serverAddressInput: String = binding.serverAddressInput.text.toString().trim()

            if (usernameInput.isEmpty() && serverAddressInput.isEmpty()) {
                Toast.makeText(applicationContext, "Informações não inseridas", Toast.LENGTH_SHORT)
                    .show()
            } else if (usernameInput.isEmpty()) {
                Toast.makeText(applicationContext, "Nome de usuário não inserido", Toast.LENGTH_SHORT).show()
            } else if (serverAddressInput.isEmpty()) {
                Toast.makeText(applicationContext, "Endereço do servidor não inserido", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, ConnectToUserActivity::class.java)
                startActivity(intent)
            }
        }
    }
}