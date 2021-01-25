package com.afdhal_fa.baseprojectlibrary.base

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

abstract class BaseFragment<viewmodel : ViewModel> : Fragment(), IBaseView {

    private val TAG = BaseFragment::class.java.simpleName

    protected lateinit var viewmodel: viewmodel
    protected lateinit var activity: Activity
    protected abstract fun initViewModel(): viewmodel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.activity = requireActivity()
        viewmodel = initViewModel()
    }

    override fun onShowProgressBar() {}

    override fun onHideProgressBar() {}
}