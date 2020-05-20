package ru.sport.home.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ExerciseDao {
    @Query("SELECT * FROM exercise")
    suspend fun getAll(): List<Exercise>?
    @Query("SELECT * FROM exercise WHERE id = :id")
    suspend fun getById(id: Long): Exercise?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employee: Exercise?)
    @Update
    suspend fun update(employee: Exercise?)
    @Delete
    suspend fun delete(employee: Exercise?)
}
