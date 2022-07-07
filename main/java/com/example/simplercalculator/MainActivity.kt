package com.example.simplercalculator

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Set on Click Listeners for Numbers
        number_onebtn.setOnClickListener { append("1", false) }
        number_twobtn.setOnClickListener { append("2", false) }
        number_threebtn.setOnClickListener { append("3", false) }
        number_fourbtn.setOnClickListener { append("4", false) }
        number_fivebtn.setOnClickListener { append("5", false) }
        number_sixbtn.setOnClickListener { append("6", false) }
        number_sevenbtn.setOnClickListener { append("7", false ) }
        number_eightbtn.setOnClickListener { append("8", false) }
        number_ninebtn.setOnClickListener { append("9", false) }
        zerobtn.setOnClickListener { append("0", false) }


        //Buttons
        cancel_button.setOnClickListener { append("", true) }
        startBracket.setOnClickListener { append("(", false) }
        closeBracket.setOnClickListener { append(")", false) }
        divideButton.setOnClickListener { append("/", false) }
        plus_btn.setOnClickListener { append("+", false) }
        multiplybtn.setOnClickListener { append("x", false) }
        number_minusbtn.setOnClickListener { append("-", false) }
        pointtbn.setOnClickListener { append(".", false) }

        //Equals and Delete buttons are not similar to the buttons
        delete_btn.setOnClickListener {
            val ex = Placeholder.text.toString()
            if (ex.isNotEmpty())
            {
                Placeholder.text = ex.substring(0, ex.length - 1)
            }
        }

        equals_btn.setOnClickListener {
            try {
                val ex = ExpressionBuilder(Placeholder.text.toString()).build()
                val result = ex.evaluate()
                val LongResult = result.toLong()
                if (result == LongResult.toDouble() )
                {
                    answer.text = LongResult.toString()
                }

            }
            catch (e: Exception)
            {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show();

                Log.d("EXCEPTION", "Message: ${e.message}")
            }
        }

    }

    private fun append(string: String, isClear: Boolean) {


        if (isClear)
        {
            Placeholder.text = ""
            answer.text = ""
        }
        else {
            Placeholder.append(string)
        }

    }
}