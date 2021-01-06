package com.afdhal_fa.baseprojectlibrary.base

import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModel

abstract class BaseToolbarActivity<viewmodel : ViewModel> : BaseActivity<viewmodel>(), IToolbar {
    protected abstract fun setToolbar(): Toolbar

    override fun onStart() {
        super.onStart()

        setSupportActionBar(setToolbar())

        if (supportActionBar != null) {
            supportActionBar?.setDisplayShowTitleEnabled(setToolbarTitle())
            supportActionBar?.setDisplayHomeAsUpEnabled(setToolbarButtonBack())
            supportActionBar?.setDisplayShowHomeEnabled(setToolbarIcon())
        }

        if (setToolbarButtonBack()) {
            setToolbar().setNavigationOnClickListener { onBackPressed() }
        }


    }

    override fun setToolbarButtonBack(): Boolean = false

    override fun setToolbarIcon(): Boolean = false

    override fun setToolbarTitle(): Boolean = false

    override fun setToolbarTitlePading(): Boolean = false


}