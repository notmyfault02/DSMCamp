package com.example.dsm_camp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main_gamestart_btn.setOnClickListener {
            val name = main_name_et.text.toString()
            startActivity<GameActivity>("username" to name)
        }
    }
}
