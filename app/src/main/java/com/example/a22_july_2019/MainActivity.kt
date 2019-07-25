package com.example.a22_july_2019

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun chooseA(v:View){
      when(v.id)
      {
          R.id.submit -> {
              var i = Intent(this, Main2Activity::class.java)
              var firstnum = num1.text.toString().toInt()
              var secondnum = num2.text.toString().toInt()

              var bundle = Bundle()
              bundle.putInt("num1", firstnum)
              bundle.putInt("num2", secondnum)
              i.putExtras(bundle)
              startActivityForResult(i, 1001)
          }
          R.id.reset ->
          {
              num1.getText().clear()
              num2.getText().clear()
              result.text = "Result: "
          }
      }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==1001 && resultCode == Activity.RESULT_OK)
        {
            var res = data?.getIntExtra("result",0)
            result.text = "Result: $res"
        }
    }

}
