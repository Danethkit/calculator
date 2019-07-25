package com.example.a22_july_2019

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    var bundle = intent.extras
        a1.text = "num1: "+bundle?.get("num1").toString()
        a2.text = "num2: "+bundle?.get("num2").toString()
    }
    fun result (v:View)
    {
        var bundle= intent.extras
        var firstnum= bundle?.get("num1").toString().toInt()
        var secondnum = bundle?.get("num2").toString().toInt()
        var res:Int = 0
        var i = Intent()
        when(v.id)
        {
            R.id.add -> res=firstnum+secondnum
            R.id.sub -> res = firstnum-secondnum
            R.id.mul -> res = firstnum * secondnum
            R.id.div -> res = firstnum/secondnum
        }
        i.putExtra("result",res)
        setResult(Activity.RESULT_OK,i)
        finish()
    }


}
