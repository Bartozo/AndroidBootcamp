package com.bartoszkrol.myanimals.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "animal_table",
    foreignKeys = [(ForeignKey(entity = AnimalType::class,
    parentColumns = ["animalType"],
    childColumns = ["type"],
    onDelete = CASCADE))])
@Parcelize
data class Animal(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                  val name: String,
                  val type: String = AnimalType.Other,
                  val description: String,
                  var favorite: Boolean = false) : Parcelable