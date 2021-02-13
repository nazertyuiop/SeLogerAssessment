package com.assessment.seloger.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.data.AnnounceRepositoryImpl
import com.assessment.domain.AnnounceRepository
import com.assessment.domain.model.Announce
import com.assessment.domain.usecases.GetListAnnouncesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val getListAnnouncesUseCase: GetListAnnouncesUseCase) :
        ViewModel() {

    private val _listAnnounce: MutableLiveData<List<Announce>> = MutableLiveData()
    val listAnnounce: LiveData<List<Announce>> get() = _listAnnounce


    fun getListAnnounces() {
        viewModelScope.launch {
            _listAnnounce.postValue(getListAnnouncesUseCase.exec())
        }
    }


}