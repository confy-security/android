package com.henriquesebastiao.confy

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
            val username: String = binding.usernameInput.text.toString().trim()
            val serverAddress: String = binding.serverAddressInput.text.toString().trim()

            if (username.isEmpty() && serverAddress.isEmpty()) {
                Toast.makeText(applicationContext, "Informações não inseridas", Toast.LENGTH_SHORT)
                    .show()
            } else if (username.isEmpty()) {
                Toast.makeText(applicationContext, "Nome de usuário não inserido", Toast.LENGTH_SHORT).show()
            } else if (serverAddress.isEmpty()) {
                Toast.makeText(applicationContext, "Endereço do servidor não inserido", Toast.LENGTH_SHORT).show()
            }
        }
    }
}