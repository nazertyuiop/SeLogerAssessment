package com.assessment.domain.usecases

import com.assessment.data.nextListAnnounces
import com.assessment.domain.AnnounceRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.IOException
import kotlin.random.Random

class GetListAnnouncesUseCaseTest {

    private val repo = mockk<AnnounceRepository>()
    private val useCase = GetListAnnouncesUseCase(repo)

    @Test
    fun `test When Success`() = runBlocking {

        //GIVEN
        val list = Random.nextListAnnounces()
        coEvery { repo.getListAnnounce() } returns list

        //WHEN
        val result = useCase.exec()

        //THEN
        assertEquals(list, result)
    }


    @Test(expected = IOException::class)
    fun `test When Failure`(): Unit = runBlocking {
        //GIVEN
        coEvery { repo.getListAnnounce() } throws IOException()

        //WHEN
        useCase.exec()
    }

}