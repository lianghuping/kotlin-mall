package com.ljp.baselibrary.widget

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.ljp.baselibrary.R

class ProgressLoading(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    companion object {
        private lateinit var mDialog: ProgressLoading
        private lateinit var animDrawable: AnimationDrawable

        fun create(context: Context): ProgressLoading {
            mDialog = ProgressLoading(context, R.style.LightDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)
            mDialog.window?.attributes?.gravity = Gravity.CENTER
            var lp = mDialog.window?.attributes
            lp?.dimAmount = 0.2f
            mDialog.window?.attributes = lp

            val mLoading = mDialog.findViewById<ImageView>(R.id.iv_loading)

            animDrawable = mLoading.background as AnimationDrawable
            return mDialog
        }
    }

    fun showLoading() {
        super.show()
        animDrawable?.start()
    }

    fun hideLoading() {
        super.hide()
        animDrawable?.stop()
    }
}