package com.forpost.testapp.presentation.userinfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.forpost.testapp.R
import com.forpost.testapp.databinding.ActivityUserInfoBinding
import com.forpost.testapp.domain.model.UserModel
import com.forpost.testapp.extention.setImage

class UserInfoActivity : AppCompatActivity() {

    companion object {
        private const val USER_MODEL = "user_model"
        fun start(context: Context, userModel: UserModel) {
            Intent(context, UserInfoActivity::class.java).putExtra(
                USER_MODEL, userModel
            ).apply {
                context.startActivity(this)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityUserInfoBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_user_info)
        intent.getParcelableExtra<UserModel>(USER_MODEL)?.let { userModel ->
            binding.userModel = userModel
            binding.imageUser.setImage(this, userModel.userImageLargePhoto)
        }
    }

}