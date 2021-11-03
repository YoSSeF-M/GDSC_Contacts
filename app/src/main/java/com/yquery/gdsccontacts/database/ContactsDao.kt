package com.yquery.gdsccontacts.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.yquery.gdsccontacts.database.ContactEntity

@Dao
interface ContactsDao {

    @Query("SELECT * FROM contact_entity ORDER BY contactID DESC")
    fun getAll(): LiveData<MutableList<ContactEntity>>

    @Insert
    suspend fun insert(contact: ContactEntity)

    @Query("DELETE FROM contact_entity")
    suspend fun deleteAll()

    @Delete
    suspend fun delete(contact: ContactEntity)

    @Update
    suspend fun update(contact: ContactEntity)

}