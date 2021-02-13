package com.assessment.seloger.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.data.AnnounceRepositoryImpl
import com.assessment.domain.model.Announce
import kotlinx.coroutines.launch

class HomeViewModel(private val annonceRepo: AnnounceRepositoryImpl) :
    ViewModel() {

    val listAnnounce: MutableLiveData<List<Announce>> = MutableLiveData()


    fun getListAnnounces() {
        viewModelScope.launch {
            listAnnounce.postValue(annonceRepo.getListAnnounce())

        }
    }


}