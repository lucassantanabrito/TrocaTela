package com.lsb.trocatela

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.net.toUri

class ConfirmarActivity : AppCompatActivity() {

    private lateinit var tvCod: TextView
    private lateinit var tvQtd: TextView
    private lateinit var tvValor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvCod = findViewById(R.id.tvCod)
        tvQtd = findViewById(R.id.tvQtd)
        tvValor = findViewById(R.id.tvValor)

        tvCod.text = intent.getStringExtra("cod")
        tvQtd.text = intent.getStringExtra("qtd")
        tvValor.text = intent.getStringExtra("valor")
    }

    fun btSmsOnClick(view: View) {
        val smsBody = "Cod: ${tvCod.text} - Qtd: ${tvQtd.text} - Valor: ${tvValor.text}"
        val smsNumber = "+5586999213456"

        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = "smsto:$smsNumber".toUri()
            putExtra("sms_body", smsBody)
        }

        startActivity(intent)
    }
}