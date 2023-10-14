package com.example.projek_alsa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projek_alsa.databinding.ActivitySummaryBinding

class summary : AppCompatActivity() {
    private lateinit var binding : ActivitySummaryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val judul = intent.getStringExtra(payment.film_name)
        val image = intent.getStringExtra(payment.image_url)
        val bioskop = intent.getStringExtra(payment.cinema)
        val seat = intent.getStringExtra(payment.ticketType)
        val harga = intent.getStringExtra(payment.price)
        val payment = intent.getStringExtra(payment.paymentMethod)
        val bank = intent.getStringExtra(com.example.projek_alsa.payment.bank)

        with(binding){
            judulTxt.text = judul
            if (image != null) {
                imgs.setImageResource(image.toInt())
            }
            cinemaTxt.text = bioskop
            SEAT.text = seat
            PRICE.text = harga
            if(payment != "Cash") {
                PAYMENT.text = "$payment, ($bank)"
            }else{
                PAYMENT.text = "$payment"
            }
        }
    }
}