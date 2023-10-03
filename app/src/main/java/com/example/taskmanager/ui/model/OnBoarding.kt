package com.example.taskmanager.ui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OnBoarding(
    @PrimaryKey
    val uid: Int? = null,
    val image:String? = null,
    val tittle:String? = null,
    val desc:String? = null
)