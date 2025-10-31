package com.henriquesebastiao.confy

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.henriquesebastiao.confy.databinding.ActivityConnectToUserBinding

class ConnectToUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConnectToUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConnectToUserBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recipientUsernameInput: String = binding.recipientUsernameInput.text.toString().trim()

        if (recipientUsernameInput.isEmpty()) {
            Toast.makeText(applicationContext, "Nome de usuário não inserido", Toast.LENGTH_SHORT).show()
        }
    }
}