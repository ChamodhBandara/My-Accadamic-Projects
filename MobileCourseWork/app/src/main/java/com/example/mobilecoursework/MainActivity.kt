package com.example.mobilecoursework

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity

//Video_Demonstration_Link-(https://drive.google.com/drive/folders/1l-QbogELm0zeTuPsAVaz2-7Gs-GhbMLa?usp=share_link)

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newGameButton = findViewById<Button>(R.id.new_game_button)
        val aboutButton = findViewById<Button>(R.id.about_button)

        aboutButton.setOnClickListener { my_button_onClick_working(aboutButton) }
        newGameButton.setOnClickListener{
            val toStartgame = Intent(this,startgame::class.java)
            startActivity(toStartgame)
        }

    }
    fun my_button_onClick_working(view: View?) {

        // step 1
        val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val popupView = inflater.inflate(R.layout.popup, null)

        // step 2
        val wid = LinearLayout.LayoutParams.WRAP_CONTENT
        val high = LinearLayout.LayoutParams.WRAP_CONTENT
        val focus= true
        val popupWindow = PopupWindow(popupView, wid, high, focus)

        // step 3
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)

    }
}