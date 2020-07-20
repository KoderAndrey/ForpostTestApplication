package com.forpost.testapp.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.forpost.testapp.R
import com.forpost.testapp.databinding.ActivityMainBinding
import com.forpost.testapp.domain.model.UserModel
import com.forpost.testapp.presentation.UserViewModel
import com.forpost.testapp.presentation.main.adapter.UserListAdapter
import com.forpost.testapp.presentation.userinfo.UserInfoActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), UserListAdapter.OnCLickUser {
    private val model: UserViewModel by inject()
    private lateinit var adapter: UserListAdapter;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = model
        model.getUsers()
        initUI()
        observeData()
    }

    private fun initUI() {
        adapter = UserListAdapter(this)
        listUsers.adapter = adapter
    }

    private fun observeData() {
        model.userData().observe(this, Observer { userList ->
            adapter.setItems(userList)
        })
        model.error().observe(this, Observer { errorMessage ->
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
        })
    }

    override fun onClick(user: UserModel) {
        UserInfoActivity.start(this, user)
    }
}