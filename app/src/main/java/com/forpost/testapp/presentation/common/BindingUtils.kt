package com.forpost.testapp.presentation.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.forpost.testapp.domain.model.UserModel
import com.forpost.testapp.presentation.main.adapter.UserListAdapter

@BindingAdapter("data")
fun  setRecyclerViewList(recyclerView: RecyclerView, items: List<UserModel>?) {
    if (recyclerView.adapter is UserListAdapter) {
        items?.let { users ->
            (recyclerView.adapter as UserListAdapter).setItems(users)
        }
    }
}