package com.forpost.testapp.extention

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

fun CircleImageView.setImage(context: Context, url: String?){
    Glide.with(context).load(url)
        .into(this)
}