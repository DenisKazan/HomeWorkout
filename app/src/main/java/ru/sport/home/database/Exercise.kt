package ru.sport.home.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Exercise(
    @PrimaryKey
    val id: Long,
    val title: Int,
    val description: Int,
    val iconRes: Int,
    val isCanRemove: Boolean
) {
    override fun toString(): String {
        return "{id = $id\ntitle = $title\ndescription = $description\nisCanRemove = $isCanRemove}"
    }
}
