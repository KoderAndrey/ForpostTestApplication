package com.forpost.testapp.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.forpost.testapp.databinding.UserItemBinding
import com.forpost.testapp.domain.model.UserModel
import com.forpost.testapp.extention.setImage


class UserListAdapter(val listener: OnCLickUser) :
    RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    val listUsers: ArrayList<UserModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int =
        listUsers.size


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(listUsers[position], listener);
    }


    class UserViewHolder(private val binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: UserModel, listener: OnCLickUser) {
            binding.userModel = model
            binding.userPhoto.setImage(binding.root.context, model.userImageIcon)
            binding.root.setOnClickListener {
                listener.onClick(model)
            }
        }
    }


    fun setItems(listUsers: List<UserModel>) {
        this.listUsers.run {
            clear()
            addAll(listUsers)
        }
        notifyDataSetChanged()
    }

    interface OnCLickUser {
        fun onClick(user: UserModel)
    }
}