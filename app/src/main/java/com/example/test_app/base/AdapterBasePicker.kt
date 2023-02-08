package com.example.test_app.base

import android.view.View

interface AdapterBasePicker<T> {


    fun onClick(item: T)

    fun onLongClick(item: T, itemView: View)
}