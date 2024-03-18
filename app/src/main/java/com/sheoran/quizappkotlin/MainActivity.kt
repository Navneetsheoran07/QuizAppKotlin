package com.sheoran.quizappkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var obj = quezData()
  lateinit var txtQheading: TextView

    lateinit var txtQ:android.widget.TextView
    lateinit var txtAns:android.widget.TextView
    lateinit var radG: RadioGroup
    lateinit var radB1: RadioButton
    lateinit var radB2:RadioButton
    lateinit var radB3:RadioButton
    lateinit var radB4:RadioButton
    lateinit var radTemp:RadioButton
    lateinit var btn: Button
    var question =
        1
    var questionLimit:kotlin.Int = 10
    var marks:kotlin.Int = 0
    var totalMarks:kotlin.Int = questionLimit
    var firstClick:kotlin.Int = 1
    var index:kotlin.Int = 0
    var Question = "Question "
    var Ans:kotlin.String? = "Ans: "
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        txtQheading = findViewById(R.id.txtQheading)
        txtQ = findViewById(R.id.txtQ)
        txtAns = findViewById(R.id.txtAns)
        radG = findViewById(R.id.radioG)
        radB1 = findViewById(R.id.radB1)
        radB2 = findViewById(R.id.radB2)
        radB3 = findViewById(R.id.radB3)
        radB4 = findViewById(R.id.radB4)
        btn = findViewById(R.id.btn)


        txtQheading.setText(Question + question)
        txtQ.setText(obj.questions[index])
        txtAns.setText("")
        radB1.setText(obj.optionA[index])
        radB2.setText(obj.optionB[index])
        radB3.setText(obj.optionC[index])
        radB4.setText(obj.optionD[index])



        radG.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            radTemp = findViewById(checkedId)
            if (radTemp.getText().toString() == obj.correctAnswers[index]) {
                radTemp.setTextColor(getColor(R.color.green))
                if (firstClick == 1) {
                    marks++
                }
            } else {
                radTemp.setTextColor(getColor(R.color.red))
            }
            txtAns.setText(Ans + obj.correctAnswers[index])
            firstClick++
        })

        btn.setOnClickListener(View.OnClickListener {
            if (question == questionLimit) {
                val i = Intent(
                    this@MainActivity,
                    resultActivity::class.java
                )
                i.putExtra("marks", marks)
                i.putExtra("totalMarks", totalMarks)
                startActivity(i)
                finish()
            } else {
                if (questionLimit == question + 1) {
                    btn.setText("Result")
                }
                radTemp!!.setChecked(false)
                //radG.clearCheck();
                question++
                index++
                txtQheading.setText(Question + question)
                txtQ.setText(obj.questions[index])
                radB1.setText(obj.optionA[index])
                radB2.setText(obj.optionB[index])
                radB3.setText(obj.optionC[index])
                radB4.setText(obj.optionD[index])
                radB1.setTextColor(getColor(R.color.black))
                radB2.setTextColor(getColor(R.color.black))
                radB3.setTextColor(getColor(R.color.black))
                radB4.setTextColor(getColor(R.color.black))
                txtAns.setText("")
                firstClick = 1
            }
        })

    }

}