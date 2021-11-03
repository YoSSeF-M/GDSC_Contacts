package com.yquery.gdsccontacts.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.yquery.gdsccontacts.database.AppDatabase
import com.yquery.gdsccontacts.database.ContactEntity
import com.yquery.gdsccontacts.database.ContactsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactViewModel(application: Application) : AndroidViewModel(application){

    val getAllContacts : LiveData<MutableList<ContactEntity>>
    private val repository : ContactsRepository

    init {
        val contactDao = AppDatabase.getDatabase(application).contactsDao()
        repository = ContactsRepository(contactDao)

        getAllContacts = repository.getAllContacts
    }

    fun insertContact(contact : ContactEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertContact(contact)
        }
    }

    fun deleteAll(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

    fun delete(contact: ContactEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.delete(contact)
        }
    }

    fun update(contact: ContactEntity){
        viewModelScope.launch {
            repository.update(contact)
        }
    }


}