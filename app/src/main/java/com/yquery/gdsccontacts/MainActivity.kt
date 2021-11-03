package com.yquery.gdsccontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yquery.gdsccontacts.adapters.ContactsAdapter
import com.yquery.gdsccontacts.database.ContactEntity
import com.yquery.gdsccontacts.databinding.ActivityMainBinding
import com.yquery.gdsccontacts.viewmodels.ContactViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: ContactViewModel
    lateinit var adapter : ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ContactsAdapter(this)

        binding.contactsRecyclerview.layoutManager = LinearLayoutManager(this)
        binding.contactsRecyclerview.adapter = adapter

        viewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

//        viewModel.insertContact(ContactEntity(0, "First", "011"))

        viewModel.getAllContacts.observe(this, {

            adapter.setData(it)

        })

    }
}