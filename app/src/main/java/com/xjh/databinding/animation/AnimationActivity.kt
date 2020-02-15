package com.xjh.databinding.animation

import android.databinding.DataBindingUtil
import android.databinding.OnRebindCallback
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
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
        binding.addOnRebindCallback(object : OnRebindCallback<ActivityAnimationBinding>() {
            @RequiresApi(Build.VERSION_CODES.KITKAT)
            override fun onPreBind(binding: ActivityAnimationBinding?): Boolean {
                val view = binding?.root as ViewGroup
                TransitionManager.beginDelayedTransition(view)
                return true
            }
        })
    }


    inner class Presenter {
        fun onCheckedChanged(view: View, isChecked: Boolean) {
            binding.showImage = isChecked
        }
    }
}
