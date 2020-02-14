package com.xjh.databinding

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.xjh.databinding.expression.ExpressionActivity
import com.xjh.databinding.list.ListActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindingList.setOnClickListener(this)
        bindingExpression.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            when (it.id) {
                R.id.bindingList -> {
                    val intent = Intent(this, ListActivity::class.java)
                    startActivity(intent)
                }
                R.id.bindingExpression -> {
                    val intent = Intent(this, ExpressionActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}
