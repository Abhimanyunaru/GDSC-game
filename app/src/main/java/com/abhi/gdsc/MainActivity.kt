package com.abhi.gdsc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val images: MutableList<Int> =
            mutableListOf(
                R.drawable.one,
                R.drawable.two,
                R.drawable.three,
                R.drawable.four,
                R.drawable.five,
                R.drawable.six,
                R.drawable.seven,
                R.drawable.eight,
                R.drawable.nine
            )

        val buttons = arrayOf(
            findViewById<ImageButton>(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9)
        )


        val cardBack = R.drawable.que
        var clicked = 0
        var turnOver = "false"
        var lastClicked = -1
        var pos = 1


        images.shuffle()

        for (i in 0..8) {

            buttons[i].tag = pos

            buttons[i].setOnClickListener {
                if (buttons[i].tag == pos && clicked < 3) {
                    buttons[i].setBackgroundResource(images[i])
                    clicked++

                    if (images[i] == R.drawable.seven) {
                        Toast.makeText(this, "Victory", Toast.LENGTH_LONG).show()
                        clicked = 3
                    }
                    if (clicked == 3) {
                        Toast.makeText(this, "You Lost!! Better Luck Next Time", Toast.LENGTH_SHORT).show()

                    }


                }
            }
        }


        val reset = findViewById<Button>(R.id.reset)
        reset.setOnClickListener{
            clicked =0
            for (i in 0..8){
                buttons[i].setBackgroundResource(cardBack)
            }
            images.shuffle()
        }



    }
}