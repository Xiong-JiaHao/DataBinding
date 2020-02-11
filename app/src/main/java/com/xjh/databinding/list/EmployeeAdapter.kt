package com.xjh.databinding.list

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xjh.databinding.BR
import com.xjh.databinding.Employee
import com.xjh.databinding.R
import java.util.*

class EmployeeAdapter() : RecyclerView.Adapter<BindingViewHolder<*>>() {

    companion object {
        private const val ITEM_VIEW_TYPE_ON = 1
        private const val ITEM_VIEW_TYPE_OFF = 2
    }

    private lateinit var mLayoutInflater: LayoutInflater
    private var mListener: OnItemClickListener? = null
    private lateinit var mEmployeeList: ArrayList<Employee>

    constructor(context: Context) : this() {
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        mEmployeeList = ArrayList()
    }

    override fun getItemViewType(position: Int): Int {
        val employee = mEmployeeList.get(position)
        if (employee.isFired.get()) {
            return ITEM_VIEW_TYPE_OFF
        }
        return ITEM_VIEW_TYPE_ON
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder<*> {
        var binding: ViewDataBinding = if (viewType == ITEM_VIEW_TYPE_ON) {
            DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee, parent, false)
        } else {
            DataBindingUtil.inflate(mLayoutInflater, R.layout.item_employee_off, parent, false)
        }
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder<*>, position: Int) {
        val employee = mEmployeeList[position]
        holder.getmBinding().setVariable(BR.item, employee)
        holder.getmBinding().executePendingBindings()
        holder.itemView.setOnClickListener {
            mListener?.onEmployeeClick(employee)
        }
    }

    override fun getItemCount(): Int {
        return mEmployeeList.size
    }

    fun setListener(listener: OnItemClickListener) {
        mListener = listener
    }

    fun addAll(employees: List<Employee>) {
        mEmployeeList.addAll(employees)
        notifyDataSetChanged()
    }

    val mRandom = Random(System.currentTimeMillis())

    fun add(employee: Employee) {
        val position = mRandom.nextInt(mEmployeeList.size + 1)
        mEmployeeList.add(position, employee)
        notifyItemInserted(position)
    }

    fun remove() {
        if (mEmployeeList.size != 0) {
            val position = mRandom.nextInt(mEmployeeList.size + 1)
            mEmployeeList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    interface OnItemClickListener {
        fun onEmployeeClick(employee: Employee)
    }
}
