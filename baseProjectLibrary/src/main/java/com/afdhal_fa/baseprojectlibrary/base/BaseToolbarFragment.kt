package com.afdhal_fa.baseprojectlibrary.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel

abstract class BaseToolbarFragment<viewmodel : ViewModel> : BaseFragment<viewmodel>(), IToolbar {

    protected abstract fun setToolbar(): Toolbar

    override fun onStart() {
        super.onStart()

        val activity = (activity as AppCompatActivity)
        activity.setSupportActionBar(setToolbar())

        if (activity.supportActionBar != null) {
            activity.supportActionBar?.setDisplayShowTitleEnabled(setToolbarTitle())
            activity.supportActionBar?.setDisplayHomeAsUpEnabled(setToolbarButtonBack())
            activity.supportActionBar?.setDisplayShowHomeEnabled(setToolbarIcon())
        }
    }

    override fun setToolbarButtonBack(): Boolean = false

    override fun setToolbarIcon(): Boolean = false

    override fun setToolbarTitle(): Boolean = false

    override fun setToolbarTitlePading(): Boolean = false

}