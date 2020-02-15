package com.xjh.databinding.animation

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.xjh.databinding.Employee
import com.xjh.databinding.R
import com.xjh.databinding.databinding.ActivityAnimationBinding
import com.xjh.databinding.databinding.ActivityExpressionBinding
import java.util.*

class AnimationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_animation)
        binding.presenter = Presenter()
    }


    inner class Presenter {
        fun onCheckedChanged(view: View, isChecked: Boolean) {
            binding.showImage = isChecked
        }
    }
}
