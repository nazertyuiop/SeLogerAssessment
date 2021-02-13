package com.assessment.seloger.ui.home

import com.assessment.seloger.BuildConfig
import com.assessment.data.AnnounceRepositoryImpl
import com.assessment.domain.model.GifObj
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import kotlinx.coroutines.withContext
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import androidx.arch.core.executor.testing.InstantTaskExecutorRule


class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun searchShouldReturnFullList() = runBlocking{

        withContext(dispatcher) {
            //given
            val giphRepositoryImpl: AnnounceRepositoryImpl = Mockito.mock(AnnounceRepositoryImpl::class.java)
            var listGiph = List<GifObj>(1){ GifObj("", null, null, null, null)}

            val viewModel = HomeViewModel(giphRepositoryImpl)
            Mockito.`when`(giphRepositoryImpl.searchGif("money", BuildConfig.API_KEY, 1)).thenReturn(
                listGiph
            )
            //when
            viewModel.searchGiph("Money")

            //then
            assertEquals(viewModel.listGiph.value?.size, 1)

        }

    }

    @Test
    fun searchShouldReturnEmptyList() = runBlocking{

        withContext(dispatcher) {
            //given
            val giphRepositoryImpl: AnnounceRepositoryImpl = Mockito.mock(AnnounceRepositoryImpl::class.java)
            val viewModel = HomeViewModel(giphRepositoryImpl)
            Mockito.`when`(giphRepositoryImpl.searchGif("money", BuildConfig.API_KEY, 1)).thenReturn(
                emptyList<GifObj>()
            )
            //when
            viewModel.searchGiph("Money")

            //then
            assertEquals(viewModel.listGiph.value?.size, 0)

        }

    }

}