package app.rental.utsavstha.rentalapp.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import app.rental.utsavstha.rentalapp.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startActivity(Intent(this@SplashActivity, MainActivity::class.java))
    }
}
