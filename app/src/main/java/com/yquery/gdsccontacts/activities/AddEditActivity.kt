package com.yquery.gdsccontacts.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.yquery.gdsccontacts.database.ContactEntity
import com.yquery.gdsccontacts.databinding.ActivityAddEditBinding
import com.yquery.gdsccontacts.viewmodels.ContactViewModel

class AddEditActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddEditBinding
    private lateinit var viewModel: ContactViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(ContactViewModel::class.java)

        val intent = intent
        val id = intent.getIntExtra("id", 0)
        val name = intent.getStringExtra("name")
        val number = intent.getStringExtra("number")
        if (((name) != null) && (number != null)) {

            binding.nameInput.setText(name)
            binding.numberInput.setText(number)

        }

        binding.saveButton.setOnClickListener {
            if (((name) != null) && (number != null)) {

                viewModel.update(
                    ContactEntity(
                        id,
                        binding.nameInput.text.toString(),
                        binding.numberInput.text.toString()
                    )
                )
                finish()

            } else {
                viewModel.insertContact(
                    ContactEntity(
                        0,
                        binding.nameInput.text.toString(),
                        binding.numberInput.text.toString()
                    )
                )
                finish()
            }
        }

    }
}