package com.yquery.gdsccontacts.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(ContactEntity::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun contactsDao() : ContactsDao

    companion object {

        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context : Context) : AppDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "ContactsDatabase")
                        .build()

                INSTANCE = instance

                instance
            }
        }

    }

}