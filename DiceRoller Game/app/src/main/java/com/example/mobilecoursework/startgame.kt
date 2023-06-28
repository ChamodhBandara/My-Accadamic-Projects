package com.example.mobilecoursework

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class startgame : AppCompatActivity() {
    private lateinit var ComputeScore:TextView
    private lateinit var UserScore:TextView
    private lateinit var target_score:TextView
    private var computer = ArrayList <ImageView> ()
    private var user = ArrayList <ImageView> ()
    private var comScore = MutableList(5){0}
    private var usScore = MutableList(5){0}
    private val userChoice = MutableList(5){false}
    private var terms:Int=0
    private var target:Int=101
    private val finalScore= MutableList(2){0}
    private var winsCount:Int=0
    private var losesCount:Int=0
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startgame)
        var  btnThrow = findViewById<Button>(R.id.throwButton)
        var btnScore = findViewById<Button>(R.id.scoreButton)
        val whoWins = findViewById<TextView>(R.id.winner)
        ComputeScore=findViewById(R.id.scoreComputer)
        UserScore=findViewById(R.id.scoreUser)
        target_score=findViewById(R.id.target)




        computer.add(findViewById<ImageView>(R.id.imageViewC_1))
        computer.add(findViewById<ImageView>(R.id.imageViewC_2))
        computer.add(findViewById<ImageView>(R.id.imageViewC_3))
        computer.add(findViewById<ImageView>(R.id.imageViewC_4))
        computer.add(findViewById<ImageView>(R.id.imageViewC_5))

        user.add(findViewById<ImageView>(R.id.imageViewU_1))
        user.add(findViewById<ImageView>(R.id.imageViewU_2))
        user.add(findViewById<ImageView>(R.id.imageViewU_3))
        user.add(findViewById<ImageView>(R.id.imageViewU_4))
        user.add(findViewById<ImageView>(R.id.imageViewU_5))

        target_score.setOnClickListener {

            if(terms==0){
                toSetTarget(target_score)
            }
        }


        for ((index, imgView) in user.withIndex()) {
            imgView.setOnClickListener {
                val setBorder: Drawable =
                    ResourcesCompat.getDrawable(resources, R.drawable.border, null)!!

                if (imgView.background == null) {
                    imgView.background = setBorder

                    userChoice[index] = true
                } else {
                    imgView.background = null
                    userChoice[index] = false
                }
            }
        }



        btnThrow.setOnClickListener {
            terms++
            btnScore.isEnabled = true
            if (terms > 2){

            }
            var selectionofview=false
            for (i in userChoice){
                if (i) selectionofview = true
            }
            if (selectionofview) {
                reroll()
            }else
                BothFaces()
            Log.d("display",userChoice.toString())

            //if the terms above 3 then automatically call the NewScore function
            if (terms % 3 == 0){
                btnScore.isEnabled=false
                updateScore(ComputeScore,UserScore,whoWins)

                for((order, image) in user.withIndex()){
                    userChoice[order]= false
                    image.background=null
                }
            }
            if( finalScore[0] == finalScore[1] && finalScore[0] >= target && terms % 3 !=0 )
            {
                Toast.makeText(this, "The Game Tied. This will Continue Until the Tie is Broken", Toast.LENGTH_SHORT).show()
                BothFaces()
            }
        }



        btnScore.setOnClickListener {
            btnScore.isEnabled = false
            if (terms %3 != 0){
                updateScore(ComputeScore,UserScore,whoWins)
            }
        }





    }

    private fun RandomGenarator(start:Int,end:Int): Int{
        return (start..end).random()
    }

    private fun SetFace(faces: ImageView): Int {
        val Nums=RandomGenarator(1,6)
        val imgResourse=resources.getIdentifier("img_face_$Nums","drawable","com.example.mobilecoursework")
        faces.setImageResource(imgResourse)
        return Nums

    }
     private fun SetFacesComputer(ImgList: List<ImageView>){
         for ((index,faces) in ImgList.withIndex()){
             var randomGenarateNum = SetFace(faces)
             comScore[index]=randomGenarateNum
         }
     }
    private fun SetFacesUser(ImgList: List<ImageView>){
        for ((index,faces) in ImgList.withIndex()){
            var randomGenarateNum = SetFace(faces)
            usScore [index] = randomGenarateNum
        }

    }
    private fun ImgstoImageView(index : Int, faces: ImageView){
        var randomGenarateNum = SetFace(faces)
        usScore [index] = randomGenarateNum
    }
    private fun BothFaces(){
        SetFacesComputer(computer)
        SetFacesUser(user)
    }


    private fun reroll(){
        for ((index, selected) in userChoice.withIndex())
            if (!selected){
                ImgstoImageView(index,user[index])
            }
            Log.d("try",userChoice.toString())
            Log.d("try",userChoice.toString())
    }
    private fun updateTheTarget(ToSetTarget: TextView){
        ToSetTarget.text = "TargetScore - $target"
    }


    @SuppressLint("MissingInflatedId")
    private fun toSetTarget(ToSetTarget: TextView) {

        // Step 2: define a PopupWindow object
        lateinit var popup: PopupWindow

        // Step 3: inflate the layout file
        val popupView = layoutInflater.inflate(R.layout.target_popup, null)

        // Step 4: set up the popup window
        popup = PopupWindow(popupView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, true)

        // Step 5: display the popup window
        popup.showAtLocation(popupView, Gravity.CENTER, 0, 0)

        // Step 6: retrieve the input
        val Submitbtn = popupView.findViewById<Button>(R.id.submit)

        Submitbtn.setOnClickListener {
            val Edit = popupView.findViewById<EditText>(R.id.edit)
            val insert = Edit.text.toString().toInt()
            // set the input to the target.
            target = insert
            updateTheTarget(ToSetTarget)
            popup.dismiss()
        }

    }

private fun win (message: String, state: Boolean){

    lateinit var  popupWindow: PopupWindow

    val popView = layoutInflater.inflate(R.layout.win_or_lose , null)

    popupWindow = PopupWindow(popView, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT, true)

    popupWindow.showAtLocation(popView,Gravity.CENTER,0,0)

    val cancelButton = popView.findViewById<Button>(R.id.cancelBtn)
    cancelButton.setOnClickListener {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
        popupWindow.dismiss()
    }



    val theState = popView.findViewById<TextView>(R.id.UserWins)
    theState.text = message
    if (state){
        theState.setTextColor(ContextCompat.getColor(this, R.color.green))
    }else{
        theState.setTextColor(ContextCompat.getColor(this, R.color.red))
    }
}

    private fun TargetFullFilment() : Int{
        var compScore : Int=finalScore[0]
        var userScore : Int=finalScore[1]
        if (compScore > userScore && compScore >= target){
            return 0
        }else if (compScore == userScore && compScore >= target){
            return 1
        }else if(userScore > compScore && userScore >= target){
            return 2
        }
        return -1
    }



    private fun updateScore(ComputerText: TextView, UserText: TextView,winersCount: TextView) {
        val ComputerTotal = comScore.sum()
        val UserTotal = usScore.sum()

        finalScore[0] += ComputerTotal
        finalScore[1] += UserTotal

        ComputeScore.text = "Computer - "  + finalScore[0].toString()
        UserScore.text = "User - " + finalScore[1].toString()

        if(TargetFullFilment() == 0){
            win(" You  Lose! ", false)
            losesCount++
            countOfWins(winersCount)
        }else if (TargetFullFilment() == 1){
          win(" Game  tie ", true)
        }else if (TargetFullFilment() == 2){
            win(" You  Win.. ", true)
            winsCount++
            countOfWins(winersCount)
        }else if (TargetFullFilment() == -1){

        }


    }
    private fun countOfWins(winersCount:TextView){
        winersCount.text="H - $winsCount, C-$losesCount"
    }




}