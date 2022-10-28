package com.example.rockpaperscissor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //變數與XML元件綁定
        val edName = findViewById<EditText>(R.id.ed_name)
        val tvText = findViewById<TextView>(R.id.tv_text)
        val btnScissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btnStone = findViewById<RadioButton>(R.id.btn_stone)
        val btnPaper = findViewById<RadioButton>(R.id.btn_paper)
        val btnMora= findViewById<Button>(R.id.btn_mora)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvWinner = findViewById<TextView>(R.id.tv_winner)
        val tvMmora = findViewById<TextView>(R.id.tv_mmora)
        val tvCmora = findViewById<TextView>(R.id.tv_cmora)
        btnMora.setOnClickListener {
            if (edName.length()<1){
                tvText.text="請請輸入玩家姓名"
                return@setOnClickListener
            }
            val playerName = edName.text
            val comMora = (Math.random()*3).toInt()
            val playerMoraText =when{
                btnScissor.isChecked->"剪刀"

                btnStone.isChecked ->"石頭"

                else-> "布"

            }
            val comMoraText = when(comMora){
                0->"剪刀"
                1->"石頭"
                else->"布"
            }
            tvName.text="名字\n$playerName"
            tvMmora.text="我方出拳\n$playerMoraText"
            tvCmora.text="電腦出拳\n$comMoraText"

            when{
                btnScissor.isChecked && comMora == 2 ||
                        btnStone.isChecked && comMora==0||
                        btnPaper.isChecked && comMora== 1->{
                    tvWinner.text="勝利者\nplayerName "
                    tvText.text ="恭喜你獲勝了！！！"
                }
                btnScissor.isChecked && comMora == 1 ||
                        btnStone.isChecked && comMora == 2 ||
                        btnPaper.isChecked && comMora == 0 ->{
                    tvWinner.text="勝利者\n電腦"
                    tvText.text ="可惜，電腦獲勝了！！！"
                }
                else->{
                    tvWinner.text="勝利者\n平手"
                    tvText.text ="評局，再試一次！！！"
                }
            }

        }
    }
}