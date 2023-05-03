package com.example.democleanarchitecture.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.democleanarchitecture.database.entities.User
import com.example.democleanarchitecture.databinding.ItemViewBinding

class UserListAdapter(private val mListener: OnItemClickUserList): ListAdapter<User, UserListAdapter.UserViewHolder>(ListDifferentiator()){

    private lateinit var binding: ItemViewBinding

    class UserViewHolder(private val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: User, listener: OnItemClickUserList){
            binding.mUser = item
            binding.clickListener = listener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        this.binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return UserViewHolder(this.binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val mUser = getItem(position)
        holder.bind(mUser, mListener)
    }

    class ListDifferentiator : DiffUtil.ItemCallback<User>(){
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return  oldItem == newItem
        }

    }
}