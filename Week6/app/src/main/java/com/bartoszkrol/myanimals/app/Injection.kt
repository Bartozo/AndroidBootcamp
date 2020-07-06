package com.bartoszkrol.myanimals.app

import com.bartoszkrol.myanimals.model.AnimalRepository
import com.bartoszkrol.myanimals.model.RoomRepository

object Injection {

    fun provideAnimalRepository(): AnimalRepository = RoomRepository()

}