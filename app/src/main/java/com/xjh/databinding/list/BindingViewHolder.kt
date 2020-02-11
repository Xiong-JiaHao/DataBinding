package com.xjh.databinding.list

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class BindingViewHolder<T : ViewDataBinding>(private val mBinding: T) : RecyclerView.ViewHolder(mBinding.root) {

    fun getmBinding(): T {
        return mBinding
    }
}
