package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Button's reaction to the user's tap or click
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            val toast = Toast.makeText(this, "You rolled!", Toast.LENGTH_SHORT)
            toast.show()
            //resultTextView.text = "6"
            rollTheDice()
        }
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollTheDice() {
        //create new dice object and roll it
        val dice = Dice(6)
        val diceRolled = dice.rollDice()

        /**
         * update the screen with the result of the dice roll
         * if a user rolls a number, dice_image is set to the corresponding number
         */
        //val resultTextView: TextView = findViewById(R.id.textView2)
        //resultTextView.text = diceRolled.toString()
        val diceImage: ImageView = findViewById(R.id.imageView)

        val drawableResource = when (diceRolled) {  //refactoring the code for better adaptability to coding practices
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
            //else -> R.drawable.ic_launcher_foreground
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRolled.toString()

        //Second dice
        val diceTwo = Dice (6)
        val diceTwoRolled = diceTwo.rollDice()

        /**
         * update the screen with the result of the second dice roll
         * if a user rolls a number, dice_image is set to the corresponding number
         */
        //val resultTextViewTwo: TextView = findViewById(R.id.textView3)
        //resultTextViewTwo.text = diceTwoRolled.toString()
        val diceTwoImage: ImageView = findViewById(R.id.imageView2)

        when (diceTwoRolled) {
            1 -> diceTwoImage.setImageResource(R.drawable.dice_1)
            2 -> diceTwoImage.setImageResource(R.drawable.dice_2)
            3 -> diceTwoImage.setImageResource(R.drawable.dice_3)
            4 -> diceTwoImage.setImageResource(R.drawable.dice_4)
            5 -> diceTwoImage.setImageResource(R.drawable.dice_5)
            6 -> diceTwoImage.setImageResource(R.drawable.dice_6)
        }
        diceTwoImage.contentDescription = diceTwoRolled.toString()
    } //rollTheDice() ends here
}

class Dice(val numSides: Int) {
    fun rollDice(): Int {
        return (1..numSides).random()
    }
}
