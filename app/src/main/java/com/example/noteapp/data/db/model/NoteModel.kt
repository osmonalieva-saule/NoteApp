package com.example.noteapp.data.db.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "noteModel")

data class NoteModel(
    //@PrimaryKey
    val title: String,
    val description: String

){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}