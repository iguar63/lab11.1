package com.example.lab11

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import com.example.lab11.databinding.ActivityMainBinding
import kotlin.math.sqrt
import kotlin.properties.Delegates.notNull


class MainActivity : AppCompatActivity() {
    var cha = 15
    var colv = 1
    lateinit var binding: ActivityMainBinding
    private var g by notNull<Boolean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null){
            g = false
        }else{
            g = savedInstanceState.getBoolean(KEY_IS_VISIBLE)
        }
        binding.butt.setOnClickListener {
            if (binding.chai.toString().toInt() != 0){
                cha = binding.chai.toString().toInt()
            }
            if (binding.colvo.toString().toInt() != 0){
                colv = binding.colvo.toString().toInt()
            }
            if (binding.mensh.isChecked){
                mensh()
            }
            if (binding.bolsh.isChecked){
                bolsh()
            }
            if (binding.blij.isChecked){
                blij()
            }

            g = true
            render()
        }

    }
    private fun render() = with(binding){
        otvet.visibility = if (g) View.VISIBLE else View.INVISIBLE
    }
    private fun blij() = with(binding) {
        var rasch = sum.toString().toDouble() - sum.toString().toInt()
        var ocr = 0.0
        rasch = sqrt(rasch * rasch)
        if(rasch >= 0.5){
            var rasch = sum.toString().toDouble() - sum.toString().toInt()
            var plus = 1 - rasch
             ocr = plus - sum.toString().toDouble()
        }else{
            var rasch = sum.toString().toDouble() - sum.toString().toInt()
             ocr = rasch - sum.toString().toDouble()
        }
        var chi = ocr*(cha*0.01)
        var obsh = chi+ocr
        var col = obsh/colv

        binding.ch.text = "Сумма чаевых = $chi"
        binding.summ.text = "Сумма чаевых = $obsh"
        binding.chel.text = "Сумма чаевых = $col"
    }
    private fun bolsh() = with(binding) {
        var rasch = sum.toString().toDouble() - sum.toString().toInt()
        rasch = sqrt(rasch * rasch)
        var plus = 1 - rasch
        var ocr = plus - sum.toString().toDouble()

        var chi = ocr*(cha*0.01)
        var obsh = chi+ocr
        var col = obsh/colv

        binding.ch.text = "Сумма чаевых = $chi"
        binding.summ.text = "Сумма чаевых = $obsh"
        binding.chel.text = "Сумма чаевых = $col"
    }
    private fun mensh() = with(binding) {
        var rasch = sum.toString().toDouble() - sum.toString().toInt()
        rasch = sqrt(rasch * rasch)
        var ocr = rasch - sum.toString().toDouble()

        var chi = ocr*(cha*0.01)
        var obsh = chi+ocr
        var col = obsh/colv

        binding.ch.text = "Сумма чаевых = $chi"
        binding.summ.text = "Сумма чаевых = $obsh"
        binding.chel.text = "Сумма чаевых = $col"
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(com.example.lab11.MainActivity.Companion.KEY_IS_VISIBLE,g)
    }
    companion object{
        @JvmStatic private val KEY_IS_VISIBLE = "IS_VISIBLE"
    }
}
