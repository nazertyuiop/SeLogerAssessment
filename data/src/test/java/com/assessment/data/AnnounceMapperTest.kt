package com.assessment.data

import com.assessment.data.network.AnnounceItemJson
import com.assessment.domain.model.Announce
import com.google.gson.annotations.SerializedName
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random


class AnnounceMapperTest {

    @Test(expected = IllegalArgumentException::class)
    fun `test toModel ThrowException when city is Null`() {
        //given
        val response = Random.nextAnnounceItemJson().copy(city = null)

        //when
        response.toModel()
    }


    @Test(expected = IllegalArgumentException::class)
    fun `test toModel ThrowException when id is Null`() {
        //given
        val response = Random.nextAnnounceItemJson().copy(id = null)

        //when
        response.toModel()
    }

}


private fun Random.nextAnnounceItemJson() = AnnounceItemJson(
    bedrooms = nextInt(),
    city = nextInt().toString(),
    id = nextInt(),
    area = nextInt(),
    url = nextInt().toString(),
    price = nextInt(),
    professional = nextInt().toString(),
    propertyType = nextInt().toString(),
    rooms = nextInt()
)