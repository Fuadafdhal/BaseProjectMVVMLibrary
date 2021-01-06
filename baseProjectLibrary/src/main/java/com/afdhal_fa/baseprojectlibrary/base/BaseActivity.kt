package com.afdhal_fa.baseprojectlibrary.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

abstract class BaseActivity<viewmodel : ViewModel> : AppCompatActivity(), IBaseView {

    private val TAG = BaseActivity::class.java.simpleName

    protected lateinit var viewmodel: viewmodel

    protected abstract fun initViewModel(): viewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewmodel = initViewModel()
    }

    override fun onShowProgressBar() {}
    override fun onHideProgressBar() {}
}