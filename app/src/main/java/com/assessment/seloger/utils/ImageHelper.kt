package com.assessment.seloger.utils

import android.widget.ImageView
import com.assessment.seloger.R
import com.bumptech.glide.Glide


fun ImageView.setImageUrl(url: String?) {
    Glide.with(this).load(url).placeholder(R.drawable.placeholder_img).into(this)
}
