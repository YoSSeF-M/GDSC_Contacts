package com.yquery.gdsccontacts.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_entity")
data class ContactEntity (

    @PrimaryKey(autoGenerate = true) val contactID : Int,
    @ColumnInfo(name = "contactName") val contactName : String?,
    @ColumnInfo(name = "contactNumber") val contactNumber : String?

)