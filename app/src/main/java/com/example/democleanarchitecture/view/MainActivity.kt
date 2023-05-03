package com.example.democleanarchitecture.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.democleanarchitecture.R
import com.example.democleanarchitecture.database.UserDatabase
import com.example.democleanarchitecture.database.entities.User
import com.example.democleanarchitecture.databinding.ActivityMainBinding
import com.example.democleanarchitecture.utils.OnItemClickUserList
import com.example.democleanarchitecture.utils.UserListAdapter
import com.example.democleanarchitecture.utils.UserRepository
import com.example.democleanarchitecture.view_models.MainViewModel
import com.example.democleanarchitecture.view_models.MainViewModelFactory
import java.util.*

class MainActivity : AppCompatActivity(), OnItemClickUserList {

    lateinit var binding: ActivityMainBinding
    lateinit var mMainViewModel: MainViewModel
    var increament = 0L;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val mUserDAO = UserDatabase.getUserDatabase(this).getUserDao()
        val mUserRepository = UserRepository(mUserDAO)
        mMainViewModel = ViewModelProvider(this, MainViewModelFactory(mUserRepository)).get(MainViewModel::class.java)

        mMainViewModel.insertUser(User(1, "B", "sw", Date(), true))

        val rvUser = binding.rvUser
        val userAdpater = UserListAdapter(this)

        rvUser.layoutManager = LinearLayoutManager(this)
        rvUser.hasFixedSize()
        rvUser.adapter= userAdpater

        rvUser.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

        mMainViewModel.getUsers().observe(this, Observer {
            increament = it.size.toLong()
            //binding.textView.text = it.toString()
            userAdpater.submitList(it)
        })

        binding.btnAdd.setOnClickListener {
            mMainViewModel.insertUser(User(++increament, "A", "sw", Date(), true))
        }

        binding.btnDelete.setOnClickListener {
            mMainViewModel.deleteUser(User(increament, "A", "sw", Date(), true))
        }
    }

    override fun onUserClick(mUser: User) {
        Toast.makeText(this, "Clicked On - ${mUser.id}", Toast.LENGTH_LONG).show()
    }
}