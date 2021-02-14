package com.assessment.seloger.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.domain.model.Announce
import com.assessment.domain.usecases.GetListAnnouncesUseCase
import com.assessment.seloger.utils.livedata.SingleLiveEvent
import kotlinx.coroutines.launch

class HomeViewModel(private val getListAnnouncesUseCase: GetListAnnouncesUseCase) : ViewModel() {

    private val _getAnnouncesEvent: MutableLiveData<GetAnnounceEvent> = SingleLiveEvent()
    val getAnnouncesEvent: LiveData<GetAnnounceEvent> get() = _getAnnouncesEvent


    fun getListAnnounces() {
        _getAnnouncesEvent.value = GetAnnounceEvent.Loading
        viewModelScope.launch {
            try {
                val listAds = getListAnnouncesUseCase.exec()
                _getAnnouncesEvent.value = GetAnnounceEvent.Success(listAds)
            } catch (e: Exception) {
                _getAnnouncesEvent.value = GetAnnounceEvent.Error(e)
            }
        }
    }

    sealed class GetAnnounceEvent {
        object Loading : GetAnnounceEvent()
        data class Error(val exception: Exception) : GetAnnounceEvent()
        data class Success(val announces: List<Announce>) : GetAnnounceEvent()
    }

}