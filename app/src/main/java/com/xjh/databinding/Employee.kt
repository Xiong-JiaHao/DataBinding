package com.xjh.databinding

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableBoolean

class Employee constructor(firstName: String, lastName: String, isFired: Boolean) : BaseObservable() {
    @get:Bindable
    var firstName: String? = null
        set(userInput) {
            field = userInput
            notifyPropertyChanged(BR.firstName)
        }
    @get:Bindable
    var lastName: String? = null
        set(result) {
            field = result
            notifyPropertyChanged(BR.lastName)
        }
    var isFired = ObservableBoolean()

    init {
        this.firstName = firstName
        this.lastName = lastName
        this.isFired.set(isFired)
    }
}