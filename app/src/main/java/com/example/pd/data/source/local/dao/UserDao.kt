package com.example.pd.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pd.data.source.local.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUserDatabase(userEntity: UserEntity)
    
    @Query("SELECT * FROM UserEntity WHERE email LIKE :email LIMIT 1")
    fun searchUserByEmail(email: String): UserEntity
    
    @Query("SELECT * FROM UserEntity")
    fun selectAllUsers(): List<UserEntity>
}