package com.yquery.gdsccontacts.database

import androidx.lifecycle.LiveData

class ContactsRepository(private val contactDao: ContactsDao) {

    val getAllContacts: LiveData<MutableList<ContactEntity>> = contactDao.getAll()

    suspend fun insertContact(contact: ContactEntity) {
        contactDao.insert(contact)
    }

    suspend fun deleteAll() {
        contactDao.deleteAll()
    }

    suspend fun delete(contact: ContactEntity) {
        contactDao.delete(contact)
    }

    suspend fun update(contact: ContactEntity){
        contactDao.update(contact)
    }

}