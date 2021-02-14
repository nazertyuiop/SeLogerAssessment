package com.assessment.seloger.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.assessment.domain.usecases.GetListAnnouncesUseCase
import com.assessment.seloger.ui.home.HomeViewModel.GetAnnounceEvent
import com.assessment.seloger.utils.MainCoroutineScopeRule
import com.assessment.seloger.utils.nextListAnnounces
import com.assessment.seloger.utils.test
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import java.io.IOException
import kotlin.random.Random

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val coroutineScope = MainCoroutineScopeRule()

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val useCase = mockk<GetListAnnouncesUseCase>()
    private val viewModel = HomeViewModel(useCase)

    @Test
    fun `test getListAnnounces Success`() {
        val announces = Random.nextListAnnounces()
        coEvery { useCase.exec() } returns announces

        val stateObserver = viewModel.getAnnouncesEvent.test()

        //WHEN
        viewModel.getListAnnounces()

        //THEN
        val states = stateObserver.valueHistory()
        assertEquals(2, states.size)
        assertTrue(states[0] is GetAnnounceEvent.Loading)
        assertTrue(states[1] is GetAnnounceEvent.Success)
        assertEquals(announces, (states[1] as GetAnnounceEvent.Success).announces)
    }

    @Test
    fun `test getListAnnounces Error`() {
        coEvery { useCase.exec() } throws IOException()

        val stateObserver = viewModel.getAnnouncesEvent.test()

        //WHEN
        viewModel.getListAnnounces()

        //THEN
        val states = stateObserver.valueHistory()
        assertEquals(2, states.size)
        assertTrue(states[0] is GetAnnounceEvent.Loading)
        assertTrue(states[1] is GetAnnounceEvent.Error)
        assertTrue((states[1] as GetAnnounceEvent.Error).exception is IOException)
    }
}