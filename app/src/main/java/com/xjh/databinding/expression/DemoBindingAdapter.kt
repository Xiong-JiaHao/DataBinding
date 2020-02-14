package com.xjh.databinding.expression

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide

class DemoBindingAdapter {

    companion object {
        @BindingAdapter("app:imageUrl", "app:placeholder")
        @JvmStatic
        fun loadImageFromUrl(view: ImageView, url: String, drawable: Drawable) {
            Glide.with(view.context).load(url).placeholder(drawable).into(view)
        }
    }
}