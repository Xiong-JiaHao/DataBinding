package com.xjh.databinding.list

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.xjh.databinding.Employee
import com.xjh.databinding.R
import com.xjh.databinding.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityListBinding
    lateinit var mEmployeeAdapter: EmployeeAdapter

    inner class Presenter {
        fun onClickAddItem(view: View) {
            mEmployeeAdapter.add(Employee("X", "JH", false))
        }

        fun onClickRemoveItem(view: View) {
            mEmployeeAdapter.remove()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        mBinding.presenter = Presenter()
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mEmployeeAdapter = EmployeeAdapter(this)
        mEmployeeAdapter.setListener(object : EmployeeAdapter.OnItemClickListener {
            override fun onEmployeeClick(employee: Employee) {
                Toast.makeText(this@ListActivity, employee.firstName, Toast.LENGTH_SHORT).show()
            }
        })
        var list = ArrayList<Employee>()
        list.add(Employee("Xiong1", "JH1", false))
        list.add(Employee("Xiong2", "JH2", false))
        list.add(Employee("Xiong3", "JH3", true))
        list.add(Employee("Xiong4", "JH4", false))
        mEmployeeAdapter.addAll(list)
        mBinding.recyclerView.adapter = mEmployeeAdapter
    }
}
