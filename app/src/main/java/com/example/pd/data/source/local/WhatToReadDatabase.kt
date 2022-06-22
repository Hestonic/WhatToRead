package com.example.pd.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.pd.data.source.local.dao.UserDao
import com.example.pd.data.source.local.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class WhatToReadDatabase : RoomDatabase() {
    
    abstract val userDao: UserDao
    
    companion object {
        @Volatile
        private var INSTANCE: WhatToReadDatabase? = null
        private const val DATABASE_NAME = "what_to_read_database"
        
        fun getDatabase(context: Context): WhatToReadDatabase {
            var tempInstance = INSTANCE
            if (tempInstance != null) return tempInstance
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WhatToReadDatabase::class.java,
                    DATABASE_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}