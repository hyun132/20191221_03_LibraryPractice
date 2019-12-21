package com.example.a20191221_03_librarypractice

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity :AppCompatActivity(){
    var mContext = this

    abstract fun setValues()
    abstract fun setupEvents()
}