package com.xjh.databinding.expression

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.xjh.databinding.Employee
import com.xjh.databinding.R
import com.xjh.databinding.databinding.ActivityExpressionBinding
import java.util.*

class ExpressionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExpressionBinding
    private val mRandom = Random(System.currentTimeMillis())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_expression)
        val employee = Employee("X", "JH", mRandom.nextBoolean())
        employee.avatar = "https://avatar.csdnimg.cn/D/4/D/1_xjh_shin.jpg"
        binding.employee = employee
    }
}
