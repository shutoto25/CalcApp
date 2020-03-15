package com.example.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()
    , View.OnClickListener {

    companion object {
        const val EXTRA_RESULT = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListener()
    }

    override fun onClick(v: View) {
        // InputTypeで制限している為、空判定だけ行う.
        if (etValue1.text.isEmpty() || etValue2.text.isEmpty()) {
            Snackbar.make(v, "数値を入力してください", Snackbar.LENGTH_SHORT).show()
            return
        }
        val value1: Double = etValue1.text.toString().toDouble()
        val value2: Double = etValue2.text.toString().toDouble()
        var result: Double? = null
        when (v.id) {
            R.id.btAdd -> result = value1 + value2
            R.id.btSub -> result = value1 - value2
            R.id.btMul -> result = value1 * value2
            R.id.btDiv -> result = value1 / value2
        }

        result?.let {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(EXTRA_RESULT, result)
            startActivity(intent)
        }
    }

    private fun setListener() {
        btAdd.setOnClickListener(this)
        btSub.setOnClickListener(this)
        btMul.setOnClickListener(this)
        btDiv.setOnClickListener(this)
    }
}

/**
 * 2つの画面があり、1つ目の画面に数値2つと演算子を選ぶと、
 * 次の画面で計算結果を表示する四則計算アプリを作成してください。
 *
 * プロジェクトを新規作成し、 CalcApp というプロジェクト名をつけてください
 * 画面を2つ作成してください
 * 1つ目の画面では、数値入力用の2つのEditTextと、四則計算それぞれのボタンを4つ作成してください
 * 4つの四則計算ボタンのどれかをタップすると、2つ目の画面へ移動させてTextViewで対応する計算結果を表示してください
 * 数値は小数点に対応してください
 * EditTextに何も値が入っていない時に四則計算ボタンをタップしてもエラーにならないようにしてください。
 */
