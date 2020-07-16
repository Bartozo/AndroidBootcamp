package com.bartoszkrol.catfacts.model.response

import com.bartoszkrol.catfacts.model.CatFact
import kotlinx.serialization.Serializable

@Serializable
data class GetCatFactsResponse(val all: List<CatFact>)